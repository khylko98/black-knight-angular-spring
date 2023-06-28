package ua.khylko98.journey;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ua.khylko98.auth.AuthRequest;
import ua.khylko98.auth.AuthResponse;
import ua.khylko98.jwt.JwtUtil;
import ua.khylko98.player.PlayerRegistrationRequest;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AuthIntegrationTest {

    private static final String AUTH_PATH = "/api/v1/auth";
    private static final String PLAYER_PATH = "/api/v1/player";

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void canLogin() {
        // create registration request
        Faker faker = new Faker();
        Name name = faker.name();

        String username = name.username();
        String password = "password";

        PlayerRegistrationRequest registrationRequest =
                PlayerRegistrationRequest.builder()
                        .username(username)
                        .password(password)
                        .build();

        AuthRequest authRequest =
                AuthRequest.builder()
                        .username(username)
                        .password(password)
                        .build();

        webTestClient.post()
                .uri(AUTH_PATH + "/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(authRequest), AuthRequest.class)
                .exchange()
                .expectStatus()
                .isUnauthorized();

        // send a post registrationRequest
        webTestClient.post()
                .uri(PLAYER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(registrationRequest),
                        PlayerRegistrationRequest.class
                )
                .exchange()
                .expectStatus()
                .isOk();

        EntityExchangeResult<AuthResponse> result = webTestClient.post()
                .uri(AUTH_PATH + "/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(authRequest), AuthRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<AuthResponse>() {
                })
                .returnResult();

        String jwtToken = Objects.requireNonNull(
                result.getResponseHeaders().get(HttpHeaders.AUTHORIZATION)
        ).get(0);

        assertThat(jwtUtil.isTokenValid(jwtToken, username)).isTrue();
    }

}

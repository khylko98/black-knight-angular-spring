package ua.khylko98.journey;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ua.khylko98.jwt.JwtUtil;
import ua.khylko98.player.PlayerRegistrationRequest;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.testcontainers.shaded.com.google.common.net.HttpHeaders.AUTHORIZATION;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PlayerIntegrationTest {

    private static final String PATH = "/api/v1/player";

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void canRegisterPlayer() {
        // create registration request
        Faker faker = new Faker();
        Name name = faker.name();

        String username = name.username();

        PlayerRegistrationRequest request = PlayerRegistrationRequest
                .builder()
                .username(username)
                .password("password")
                .build();

        // send post request
        String jwtToken = Objects.requireNonNull(webTestClient
                .post()
                .uri(PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), PlayerRegistrationRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Void.class)
                .getResponseHeaders()
                .get(AUTHORIZATION)).get(0);

        assertThat(jwtUtil.isTokenValid(jwtToken, username)).isTrue();
    }

}

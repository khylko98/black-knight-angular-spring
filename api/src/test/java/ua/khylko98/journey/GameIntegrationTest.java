package ua.khylko98.journey;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ua.khylko98.player.PlayerRegistrationRequest;
import ua.khylko98.util.JsonFileReader;

import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.testcontainers.shaded.com.google.common.net.HttpHeaders.AUTHORIZATION;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class GameIntegrationTest {

    private static final String PLAYER_PATH = "/api/v1/player";
    private static final String GAME_PATH = "/api/v1/game";

    @Autowired
    private WebTestClient webTestClient;
    private JsonFileReader jsonFileReader;

    @BeforeEach
    void setUp() {
        jsonFileReader = new JsonFileReader();
    }

    @Test
    void canPlayGame() {
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
                .uri(PLAYER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), PlayerRegistrationRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Void.class)
                .getResponseHeaders()
                .get(AUTHORIZATION)).get(0);

        Map<String, Object> actual = webTestClient.get()
                .uri(GAME_PATH + "?name=prologue")
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<Map<String, Object>>() {
                })
                .returnResult()
                .getResponseBody();

        assertThat(actual).isNotEmpty();

        String pathToJsons = "src/main/resources/static/game/json/";
        String fileName = "prologue";
        String num = "";
        String part = "";
        String fullPath = String.format(
                "%s%s%s%s.json",
                pathToJsons,
                fileName,
                num,
                part
        );

        Map<String, Object> expected = jsonFileReader.readJsonFile(fullPath);

        assertThat(actual).isEqualTo(expected);
    }

}

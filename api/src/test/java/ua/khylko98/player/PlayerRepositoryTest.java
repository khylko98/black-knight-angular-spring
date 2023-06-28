package ua.khylko98.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ua.khylko98.AbstractTestcontainers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
class PlayerRepositoryTest extends AbstractTestcontainers {

    @Autowired
    private PlayerRepository underTest;

    @BeforeEach
    void setUp() {
        underTest.deleteAll();
    }

    @Test
    void existsPlayerByUsername() {
        // Given
        String username = FAKER.name().username();
        Player player = new Player(username, "password");

        underTest.save(player);

        // When
        boolean actual = underTest.existsPlayerByUsername(username);

        // Then
        assertThat(actual).isTrue();
    }

    @Test
    void existsPlayerByUsernameFailsWhenUsernameNotPresent() {
        // Given
        String username = FAKER.name().username();

        // When
        boolean actual = underTest.existsPlayerByUsername(username);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void findPlayerByUsername() {
        // Given
        String username = FAKER.name().username();
        Player player = new Player(username, "password");

        underTest.save(player);

        // When
        Optional<Player> actual = underTest.findPlayerByUsername(username);

        // Then
        assertThat(actual.isPresent()).isTrue();
        assertThat(actual.get().getUsername()).isEqualTo(username);
    }

    @Test
    void findPlayerByUsernameFailsWhenUsernameNotPresent() {
        // Given
        String username = FAKER.name().username();

        // When
        Optional<Player> actual = underTest.findPlayerByUsername(username);

        // Then
        assertThat(actual.isPresent()).isFalse();
    }

}

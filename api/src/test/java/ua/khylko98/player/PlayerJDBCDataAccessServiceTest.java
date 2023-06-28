package ua.khylko98.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khylko98.AbstractTestcontainers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerJDBCDataAccessServiceTest extends AbstractTestcontainers {

    private final PlayerRowMapper userRowMapper = new PlayerRowMapper();

    private PlayerJDBCDataAccessService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlayerJDBCDataAccessService(
                getJdbcTemplate(),
                userRowMapper
        );
    }

    @Test
    void existsPlayerWithUsername() {
        // Given
        String username = FAKER.name().username();
        Player player = new Player(username, "password");

        underTest.insertPlayer(player);

        // When
        boolean actual = underTest.existsPlayerWithUsername(username);

        // Then
        assertThat(actual).isTrue();
    }

    @Test
    void existsPlayerWithUsernameReturnsFalseWhenDoesNotExists() {
        // Given
        String username = FAKER.name().username();

        // When
        boolean actual = underTest.existsPlayerWithUsername(username);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void selectPlayerByUsername() {
        // Given
        String username = FAKER.name().username();
        Player player = new Player(username, "password");

        underTest.insertPlayer(player);

        // When
        Optional<Player> actual = underTest.selectPlayerByUsername(username);

        // Then
        assertThat(actual.isPresent()).isTrue();
        assertThat(actual.get().getUsername()).isEqualTo(username);
    }

    @Test
    void selectPlayerByUsernameFailsWhenUsernameNotPresent() {
        // Given
        String username = FAKER.name().username();

        // When
        Optional<Player> actual = underTest.selectPlayerByUsername(username);

        // Then
        assertThat(actual.isPresent()).isFalse();
    }

}

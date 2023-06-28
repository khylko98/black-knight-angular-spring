package ua.khylko98.player;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerRowMapperTest {

    @Test
    void mapRow() throws SQLException {
        // Given
        PlayerRowMapper playerRowMapper = new PlayerRowMapper();

        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getLong("id"))
                .thenReturn(1L);
        when(resultSet.getString("username"))
                .thenReturn("Player");
        when(resultSet.getString("password"))
                .thenReturn("password");

        // When
        Player actual = playerRowMapper.mapRow(resultSet, 1);

        // Then
        Player expected = new Player(
                1L,
                "Player",
                "password"
        );

        assertThat(actual).isEqualTo(expected);
    }

}

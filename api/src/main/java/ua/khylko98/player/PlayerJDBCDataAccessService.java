package ua.khylko98.player;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("jdbc")
@AllArgsConstructor
public class PlayerJDBCDataAccessService implements PlayerDAO {

    private final JdbcTemplate jdbcTemplate;
    private final PlayerRowMapper playerRowMapper;

    @Override
    public void insertPlayer(Player player) {
        var sql = """
                INSERT INTO player(username, password) VALUES(?, ?);
                """;

        jdbcTemplate.update(
                sql,
                player.getUsername(),
                player.getPassword()
        );
    }

    @Override
    public boolean existsPlayerWithUsername(String username) {
        var sql = """
                SELECT count(id) FROM player WHERE username=?;
                """;

        Long count = jdbcTemplate.queryForObject(
                sql,
                Long.class,
                username
        );

        return count != null && count > 0;
    }

    @Override
    public Optional<Player> selectPlayerByUsername(String username) {
        var sql = """
                SELECT id, username, password FROM player WHERE username=?;
                """;

        return jdbcTemplate.query(sql, playerRowMapper, username)
                .stream()
                .findFirst();
    }

}

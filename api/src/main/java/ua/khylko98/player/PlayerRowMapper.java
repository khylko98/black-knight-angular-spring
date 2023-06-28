package ua.khylko98.player;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlayerRowMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Player(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
        );
    }

}

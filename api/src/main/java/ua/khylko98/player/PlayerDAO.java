package ua.khylko98.player;

import java.util.Optional;

public interface PlayerDAO {

    void insertPlayer(Player player);

    boolean existsPlayerWithUsername(String username);

    Optional<Player> selectPlayerByUsername(String username);

}

package ua.khylko98.player;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("jpa")
@AllArgsConstructor
public class PlayerJPADataAccessService implements PlayerDAO {

    private final PlayerRepository playerRepository;

    @Override
    public void insertPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public boolean existsPlayerWithUsername(String username) {
        return playerRepository.existsPlayerByUsername(username);
    }

    @Override
    public Optional<Player> selectPlayerByUsername(String username) {
        return playerRepository.findPlayerByUsername(username);
    }

}

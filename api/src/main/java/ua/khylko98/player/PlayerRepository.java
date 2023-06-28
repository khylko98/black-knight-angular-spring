package ua.khylko98.player;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {

    boolean existsPlayerByUsername(String username);

    Optional<Player> findPlayerByUsername(String username);

}

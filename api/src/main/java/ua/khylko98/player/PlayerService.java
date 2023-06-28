package ua.khylko98.player;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.khylko98.exception.PlayerWithThisUsernameAlreadyCreatedException;

@Service
public class PlayerService {

    private final PlayerDAO playerDAO;
    private final PasswordEncoder passwordEncoder;

    public PlayerService(@Qualifier("jpa") PlayerDAO playerDAO,
                         PasswordEncoder passwordEncoder
    ) {
        this.playerDAO = playerDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public void addPlayer(PlayerRegistrationRequest request) {
        String username = request.getUsername();

        if (playerDAO.existsPlayerWithUsername(username)) {
            throw new PlayerWithThisUsernameAlreadyCreatedException(
                    "Player with this username already created"
            );
        }

        Player player = new Player(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword())
        );

        playerDAO.insertPlayer(player);
    }

}

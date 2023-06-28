package ua.khylko98.player;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayerDetailsService implements UserDetailsService {

    private final PlayerDAO playerDAO;

    public PlayerDetailsService(@Qualifier("jpa") PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return playerDAO.selectPlayerByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Username '" + username + "' not found"
                ));
    }

}

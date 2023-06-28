package ua.khylko98.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ua.khylko98.jwt.JwtUtil;
import ua.khylko98.player.Player;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Player principal = (Player) authentication.getPrincipal();

        String token = jwtUtil.issueToken(
                principal.getUsername(),
                principal.getPassword()
        );

        return AuthResponse.builder()
                .token(token)
                .build();
    }

}

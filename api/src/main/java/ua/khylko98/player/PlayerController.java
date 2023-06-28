package ua.khylko98.player;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.khylko98.jwt.JwtUtil;

@RestController
@RequestMapping("api/v1/player")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> registerPlayer(
            @RequestBody
            PlayerRegistrationRequest request
    ) {
        playerService.addPlayer(request);

        String jwtToken = jwtUtil.issueToken(
                request.getUsername(),
                "ROLE_PLAYER"
        );

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwtToken)
                .build();
    }

}

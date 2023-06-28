package ua.khylko98.game;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/game")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<?> game(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "") String num,
            @RequestParam(required = false, defaultValue = "") String part
    ) {
        Map<String, Object> responseBody = gameService.findGameText(
                name,
                num,
                part
        );

        return ResponseEntity.ok(responseBody);
    }

}

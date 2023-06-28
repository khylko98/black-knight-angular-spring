package ua.khylko98.game;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.khylko98.util.JsonFileReader;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GameService {

    private final JsonFileReader jsonFileReader;

    @Value("#{'${path.static.game.json}'}")
    private String pathToJsons;

    public Map<String, Object> findGameText(
            String fileName,
            String num,
            String part
    ) {
        String path = String.format(
                "%s%s%s%s.json",
                pathToJsons,
                fileName,
                num,
                part
        );

        return jsonFileReader.readJsonFile(path);
    }

}

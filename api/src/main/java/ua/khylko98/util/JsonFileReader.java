package ua.khylko98.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ua.khylko98.exception.JsonFileReaderException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

@Component
public class JsonFileReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Object> readJsonFile(String path) {
        try {
            return objectMapper.readValue(
                    Paths.get(path).toFile(),
                    Map.class
            );
        } catch (IOException e) {
            throw new JsonFileReaderException(e.getMessage());
        }
    }

}

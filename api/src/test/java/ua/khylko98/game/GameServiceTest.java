package ua.khylko98.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.khylko98.util.JsonFileReader;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {

    private GameService underTest;

    @Mock
    private JsonFileReader jsonFileReader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new GameService(jsonFileReader);
    }

    @Test
    void findGameText() {
        // Given
        String pathToJsons = "src/main/resources/static/game/json/";
        String fileName = "prologue";
        String num = "";
        String part = "";
        String fullPath = String.format(
                "%s%s%s%s.json",
                pathToJsons,
                fileName,
                num,
                part
        );

        Map<String, Object> expectedMap = jsonFileReader.readJsonFile(fullPath);

        // When
        Map<String, Object> result = underTest.findGameText(
                fileName,
                num,
                part
        );

        // Then
        assertEquals(expectedMap, result);
    }

}

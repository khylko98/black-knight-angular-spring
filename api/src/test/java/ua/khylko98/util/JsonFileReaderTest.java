package ua.khylko98.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.khylko98.exception.JsonFileReaderException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class JsonFileReaderTest {

    @Mock
    private ObjectMapper objectMapper;
    private JsonFileReader underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new JsonFileReader();
    }

    @Test
    void readJsonFile() throws IOException {
        // Given
        String path = "src/test/resources/test.json";
        File file = new File(path);
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("test", "test");

        when(objectMapper.readValue(file, Map.class))
                .thenReturn(expectedMap);

        // When
        Map<String, Object> result = underTest.readJsonFile(path);

        // Then
        assertEquals(expectedMap, result);
    }

    @Test
    void readJsonFileExceptionThrown() throws IOException {
        // Given
        String path = "src/test/resources/exc_test.json";
        File file = new File(path);

        when(objectMapper.readValue(file, Map.class))
                .thenThrow(new IOException("File not found"));

        // Then
        assertThrows(JsonFileReaderException.class,
                () -> underTest.readJsonFile(path));
    }

}

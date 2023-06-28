package ua.khylko98.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class JsonFileReaderException extends RuntimeException {

    public JsonFileReaderException(String message) {
        super(message);
    }

}

package ua.khylko98.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class PlayerWithThisUsernameAlreadyCreatedException
        extends RuntimeException {

    public PlayerWithThisUsernameAlreadyCreatedException(String message) {
        super(message);
    }

}

package ua.khylko98.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(PlayerWithThisUsernameAlreadyCreatedException.class)
    public ResponseEntity<ErrorResponse> handleException(
            PlayerWithThisUsernameAlreadyCreatedException e,
            HttpServletRequest request
    ) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .statusCode(HttpStatus.CONFLICT.value())
                .localDateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(JsonFileReaderException.class)
    public ResponseEntity<ErrorResponse> handleException(
            JsonFileReaderException e,
            HttpServletRequest request
    ) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .localDateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleException(
            InsufficientAuthenticationException e,
            HttpServletRequest request
    ) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .statusCode(HttpStatus.FORBIDDEN.value())
                .localDateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleException(
            BadCredentialsException e,
            HttpServletRequest request
    ) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .localDateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception e,
            HttpServletRequest request
    ) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .localDateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}

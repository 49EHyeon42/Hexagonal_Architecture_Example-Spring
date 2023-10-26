package dev.ehyeon.attendance.global;

import dev.ehyeon.attendance.global.error.Error;
import dev.ehyeon.attendance.global.error.ErrorResponse;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse methodArgumentNotValidExceptionHandler() {
        return new ErrorResponse(Error.BAD_REQUEST.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userNotFoundExceptionHandler() {
        return new ErrorResponse(Error.USER_NOT_FOUND.getMessage());
    }
}

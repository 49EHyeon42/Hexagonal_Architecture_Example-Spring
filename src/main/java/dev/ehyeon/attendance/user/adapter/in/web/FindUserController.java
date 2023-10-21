package dev.ehyeon.attendance.user.adapter.in.web;

import dev.ehyeon.attendance.global.error.Error;
import dev.ehyeon.attendance.global.error.ErrorResponse;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserNotFoundException;
import dev.ehyeon.attendance.user.application.port.in.FindUserByIdResponse;
import dev.ehyeon.attendance.user.application.port.in.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindUserController {

    private final FindUserUseCase findUserUseCase;

    @GetMapping("/user")
    public FindUserByIdResponse findUserById(long id) {
        return findUserUseCase.findUserById(id);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userNotFoundExceptionHandler() {
        return new ErrorResponse(Error.USER_NOT_FOUND.getMessage());
    }
}

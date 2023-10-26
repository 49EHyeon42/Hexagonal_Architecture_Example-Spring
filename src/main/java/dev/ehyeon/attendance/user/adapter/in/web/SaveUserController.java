package dev.ehyeon.attendance.user.adapter.in.web;

import dev.ehyeon.attendance.global.error.Error;
import dev.ehyeon.attendance.global.error.ErrorResponse;
import dev.ehyeon.attendance.user.adapter.out.persistence.DuplicatedIdException;
import dev.ehyeon.attendance.user.application.port.in.SaveUserByIdRequest;
import dev.ehyeon.attendance.user.application.port.in.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SaveUserController {

    private final SaveUserUseCase saveUserUseCase;

    @PostMapping("/user")
    public void saveUserById(@RequestBody @Valid SaveUserByIdRequest saveUserByIdRequest) {
        saveUserUseCase.saveUserById(saveUserByIdRequest.getId());
    }

    @ExceptionHandler(DuplicatedIdException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse duplicatedIdExceptionHandler() {
        return new ErrorResponse(Error.DUPLICATED_ID.getMessage());
    }
}

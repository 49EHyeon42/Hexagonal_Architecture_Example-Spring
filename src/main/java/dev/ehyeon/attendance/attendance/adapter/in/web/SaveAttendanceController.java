package dev.ehyeon.attendance.attendance.adapter.in.web;

import dev.ehyeon.attendance.attendance.application.port.in.SaveAttendanceByIdRequest;
import dev.ehyeon.attendance.attendance.application.port.in.SaveAttendanceUseCase;
import dev.ehyeon.attendance.attendance.application.service.DuplicatedAttendanceException;
import dev.ehyeon.attendance.global.error.Error;
import dev.ehyeon.attendance.global.error.ErrorResponse;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SaveAttendanceController {

    private final SaveAttendanceUseCase saveAttendanceUseCase;

    @PostMapping("/attendance")
    public void saveAttendanceById(@RequestBody @Valid SaveAttendanceByIdRequest saveAttendanceByIdRequest) {
        saveAttendanceUseCase.saveAttendanceByUserId(saveAttendanceByIdRequest.getId());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userNotFoundExceptionHandler() {
        return new ErrorResponse(Error.USER_NOT_FOUND.getMessage());
    }

    @ExceptionHandler(DuplicatedAttendanceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse duplicatedAttendanceExceptionHandler() {
        return new ErrorResponse(Error.DUPLICATED_ATTENDANCE.getMessage());
    }
}

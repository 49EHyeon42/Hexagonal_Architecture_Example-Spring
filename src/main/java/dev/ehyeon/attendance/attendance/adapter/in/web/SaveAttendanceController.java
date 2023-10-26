package dev.ehyeon.attendance.attendance.adapter.in.web;

import dev.ehyeon.attendance.attendance.application.port.in.SaveAttendanceByUserIdRequest;
import dev.ehyeon.attendance.attendance.application.port.in.SaveAttendanceUseCase;
import dev.ehyeon.attendance.attendance.application.service.DuplicatedAttendanceException;
import dev.ehyeon.attendance.global.error.Error;
import dev.ehyeon.attendance.global.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SaveAttendanceController {

    private final SaveAttendanceUseCase saveAttendanceUseCase;

    @PostMapping("/attendance")
    public void saveAttendanceByUserId(@RequestBody @Valid SaveAttendanceByUserIdRequest saveAttendanceByUserIdRequest) {
        saveAttendanceUseCase.saveAttendanceByUserId(saveAttendanceByUserIdRequest.getUserId());
    }

    @ExceptionHandler(DuplicatedAttendanceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse duplicatedAttendanceExceptionHandler() {
        return new ErrorResponse(Error.DUPLICATED_ATTENDANCE.getMessage());
    }
}

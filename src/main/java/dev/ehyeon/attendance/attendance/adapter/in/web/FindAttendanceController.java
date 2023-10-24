package dev.ehyeon.attendance.attendance.adapter.in.web;

import dev.ehyeon.attendance.attendance.application.port.in.FindAttendanceByUserIdAndDateBetweenRequest;
import dev.ehyeon.attendance.attendance.application.port.in.FindAttendanceUseCase;
import dev.ehyeon.attendance.global.error.Error;
import dev.ehyeon.attendance.global.error.ErrorResponse;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FindAttendanceController {

    private final FindAttendanceUseCase findAttendanceUseCase;

    @GetMapping("/attendance")
    public List<LocalDate> findAttendanceByUserIdAndDateBetween(FindAttendanceByUserIdAndDateBetweenRequest findAttendanceByUserIdAndDateBetweenRequest) {
        return findAttendanceUseCase.findAttendanceByUserIdAndDateBetween(findAttendanceByUserIdAndDateBetweenRequest);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userNotFoundExceptionHandler() {
        return new ErrorResponse(Error.USER_NOT_FOUND.getMessage());
    }
}

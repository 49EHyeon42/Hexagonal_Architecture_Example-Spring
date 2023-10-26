package dev.ehyeon.attendance.attendance.adapter.in.web;

import dev.ehyeon.attendance.attendance.application.port.in.FindAttendanceByUserIdAndDateBetweenRequest;
import dev.ehyeon.attendance.attendance.application.port.in.FindAttendanceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
}

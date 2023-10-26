package dev.ehyeon.attendance.attendance.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class FindAttendanceByUserIdAndDateBetweenRequest {

    private final long userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final LocalDate from;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final LocalDate to;
}

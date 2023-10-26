package dev.ehyeon.attendance.attendance.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Attendance {

    private final long userId;
    private final LocalDate date;
}

package dev.ehyeon.attendance.attendance.application.port.out;

import dev.ehyeon.attendance.attendance.domain.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface FindAttendancePort {

    List<Attendance> findAllAttendanceByUserIdAndDateBetween(long userId, LocalDate from, LocalDate to);
}

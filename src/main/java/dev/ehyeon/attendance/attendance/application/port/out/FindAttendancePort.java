package dev.ehyeon.attendance.attendance.application.port.out;

import dev.ehyeon.attendance.attendance.domain.Attendance;
import dev.ehyeon.attendance.user.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface FindAttendancePort {

    List<Attendance> findAllAttendanceByUserAndDateBetween(User user, LocalDate from, LocalDate to);
}

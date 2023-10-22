package dev.ehyeon.attendance.attendance.application.port.out;

import dev.ehyeon.attendance.user.domain.User;

import java.time.LocalDate;

public interface SaveAttendancePort {

    void saveAttendanceByUserAndDate(User user, LocalDate date);
}

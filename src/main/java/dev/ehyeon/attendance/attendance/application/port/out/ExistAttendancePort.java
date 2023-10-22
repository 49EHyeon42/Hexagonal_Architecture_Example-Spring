package dev.ehyeon.attendance.attendance.application.port.out;

import dev.ehyeon.attendance.user.domain.User;

import java.time.LocalDate;

public interface ExistAttendancePort {

    boolean existAttendanceByUserAndDate(User user, LocalDate date);
}

package dev.ehyeon.attendance.attendance.application.port.out;

import java.time.LocalDate;

public interface ExistAttendancePort {

    boolean existAttendanceByUserIdAndDate(long userId, LocalDate date);
}

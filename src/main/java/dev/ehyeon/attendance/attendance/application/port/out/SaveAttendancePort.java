package dev.ehyeon.attendance.attendance.application.port.out;

import java.time.LocalDate;

public interface SaveAttendancePort {

    void saveAttendanceByUserIdAndDate(long userId, LocalDate date);
}

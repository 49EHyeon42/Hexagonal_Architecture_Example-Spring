package dev.ehyeon.attendance.attendance.application.port.in;

public interface SaveAttendanceUseCase {

    void saveAttendanceByUserId(long userId);
}

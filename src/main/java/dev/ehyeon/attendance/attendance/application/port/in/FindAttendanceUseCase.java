package dev.ehyeon.attendance.attendance.application.port.in;

import java.time.LocalDate;
import java.util.List;

public interface FindAttendanceUseCase {

    List<LocalDate> findAttendanceByUserIdAndDateBetween(FindAttendanceByUserIdAndDateBetweenRequest findAttendanceByUserIdAndDateBetweenRequest);
}

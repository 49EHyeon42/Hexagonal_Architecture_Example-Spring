package dev.ehyeon.attendance.attendance.application.service;

import dev.ehyeon.attendance.attendance.application.port.in.SaveAttendanceUseCase;
import dev.ehyeon.attendance.attendance.application.port.out.ExistAttendancePort;
import dev.ehyeon.attendance.attendance.application.port.out.SaveAttendancePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SaveAttendanceService implements SaveAttendanceUseCase {

    private final ExistAttendancePort existAttendancePort;
    private final SaveAttendancePort saveAttendancePort;

    @Override
    public void saveAttendanceByUserId(long userId) {
        LocalDate now = LocalDate.now();

        if (existAttendancePort.existAttendanceByUserIdAndDate(userId, now)) {
            throw new DuplicatedAttendanceException();
        }

        saveAttendancePort.saveAttendanceByUserIdAndDate(userId, now);
    }
}

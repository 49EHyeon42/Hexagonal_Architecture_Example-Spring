package dev.ehyeon.attendance.attendance.application.service;

import dev.ehyeon.attendance.attendance.application.port.in.SaveAttendanceUseCase;
import dev.ehyeon.attendance.attendance.application.port.out.ExistAttendancePort;
import dev.ehyeon.attendance.attendance.application.port.out.SaveAttendancePort;
import dev.ehyeon.attendance.user.application.port.out.FindUserPort;
import dev.ehyeon.attendance.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SaveAttendanceService implements SaveAttendanceUseCase {

    private final FindUserPort findUserPort;
    private final ExistAttendancePort existAttendancePort;
    private final SaveAttendancePort saveAttendancePort;

    @Override
    public void saveAttendanceByUserId(long userId) {
        User user = findUserPort.findUserById(userId);

        LocalDate now = LocalDate.now();

        if (existAttendancePort.existAttendanceByUserAndDate(user, now)) {
            throw new DuplicatedAttendanceException();
        }

        saveAttendancePort.saveAttendanceByUserAndDate(user, now);
    }
}

package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.attendance.application.port.out.ExistAttendancePort;
import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;
import dev.ehyeon.attendance.user.application.port.out.FindUserEntityPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@PersistenceAdapter
@RequiredArgsConstructor
public class ExistAttendanceAdapter implements ExistAttendancePort {

    private final FindUserEntityPort findUserEntityPort;
    private final AttendanceJpaRepository attendanceJpaRepository;

    @Override
    public boolean existAttendanceByUserIdAndDate(long userId, LocalDate date) {
        UserEntity foundUserEntity = findUserEntityPort.findUserEntityById(userId);

        return attendanceJpaRepository.existsById(new AttendanceEntityId(foundUserEntity, date));
    }
}

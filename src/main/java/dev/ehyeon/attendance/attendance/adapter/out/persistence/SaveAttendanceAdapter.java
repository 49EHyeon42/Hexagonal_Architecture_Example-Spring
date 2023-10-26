package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.attendance.application.port.out.SaveAttendancePort;
import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;
import dev.ehyeon.attendance.user.application.port.out.FindUserEntityPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveAttendanceAdapter implements SaveAttendancePort {

    private final FindUserEntityPort findUserEntityPort;
    private final AttendanceJpaRepository attendanceJpaRepository;

    @Override
    public void saveAttendanceByUserIdAndDate(long userId, LocalDate date) {
        UserEntity foundUserEntity = findUserEntityPort.findUserEntityById(userId);

        attendanceJpaRepository.save(new AttendanceEntity(new AttendanceEntityId(foundUserEntity, date)));
    }
}

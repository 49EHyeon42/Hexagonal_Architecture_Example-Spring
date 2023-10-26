package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.attendance.application.port.out.FindAttendancePort;
import dev.ehyeon.attendance.attendance.domain.Attendance;
import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;
import dev.ehyeon.attendance.user.application.port.out.FindUserEntityPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAttendanceAdapter implements FindAttendancePort {

    private final FindUserEntityPort findUserEntityPort;
    private final AttendanceJpaRepository attendanceJpaRepository;
    private final AttendanceMapper attendanceMapper;

    @Override
    public List<Attendance> findAllAttendanceByUserIdAndDateBetween(long userId, LocalDate from, LocalDate to) {
        UserEntity foundUserEntity = findUserEntityPort.findUserEntityById(userId);

        List<AttendanceEntity> foundAttendanceEntities = attendanceJpaRepository
                .findByAttendanceEntityIdUserEntityAndAttendanceEntityIdLocalDateBetween(foundUserEntity, from, to);

        return foundAttendanceEntities.stream()
                .map(attendanceMapper::attendanceEntityToAttendance)
                .collect(Collectors.toList());
    }
}

package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.attendance.application.port.out.FindAttendancePort;
import dev.ehyeon.attendance.attendance.domain.Attendance;
import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserJpaRepository;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserNotFoundException;
import dev.ehyeon.attendance.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAttendanceAdapter implements FindAttendancePort {

    private final UserJpaRepository userJpaRepository;
    private final AttendanceJpaRepository attendanceJpaRepository;
    private final AttendanceMapper attendanceMapper;

    @Override
    public List<Attendance> findAllAttendanceByUserAndDateBetween(User user, LocalDate from, LocalDate to) {
        UserEntity foundUserEntity = userJpaRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);

        List<AttendanceEntity> foundAttendanceEntities = attendanceJpaRepository
                .findByAttendanceEntityIdUserEntityAndAttendanceEntityIdLocalDateBetween(foundUserEntity, from, to);

        return foundAttendanceEntities.stream()
                .map(attendanceMapper::attendanceEntityToAttendance)
                .collect(Collectors.toList());
    }
}

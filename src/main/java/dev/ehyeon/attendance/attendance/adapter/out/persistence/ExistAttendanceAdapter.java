package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.attendance.application.port.out.ExistAttendancePort;
import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserJpaRepository;
import dev.ehyeon.attendance.user.adapter.out.persistence.UserNotFoundException;
import dev.ehyeon.attendance.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@PersistenceAdapter
@RequiredArgsConstructor
public class ExistAttendanceAdapter implements ExistAttendancePort {

    private final UserJpaRepository userJpaRepository;
    private final AttendanceJpaRepository attendanceJpaRepository;

    @Override
    public boolean existAttendanceByUserAndDate(User user, LocalDate date) {
        UserEntity foundUserEntity = userJpaRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);

        return attendanceJpaRepository.existsById(new AttendanceEntityId(foundUserEntity, date));
    }
}

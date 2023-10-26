package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceJpaRepository extends JpaRepository<AttendanceEntity, AttendanceEntityId> {

    List<AttendanceEntity> findByAttendanceEntityIdUserEntityAndAttendanceEntityIdDateBetween(UserEntity userEntity, LocalDate from, LocalDate to);
}

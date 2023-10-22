package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceJpaRepository extends JpaRepository<AttendanceEntity, AttendanceEntityId> {

}

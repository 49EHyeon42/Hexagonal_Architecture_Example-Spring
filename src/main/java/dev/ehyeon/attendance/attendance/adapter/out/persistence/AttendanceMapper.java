package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.attendance.domain.Attendance;
import dev.ehyeon.attendance.global.annotation.Mapper;

@Mapper
public class AttendanceMapper {

    public Attendance attendanceEntityToAttendance(AttendanceEntity attendanceEntity) {
        return new Attendance(attendanceEntity.getUserId(), attendanceEntity.getLocalDate());
    }
}

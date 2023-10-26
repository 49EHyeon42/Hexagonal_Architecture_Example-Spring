package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class AttendanceEntity {

    @EmbeddedId
    private AttendanceEntityId attendanceEntityId;

    public long getUserId() {
        return attendanceEntityId.getUserEntity().getId();
    }

    public LocalDate getDate() {
        return attendanceEntityId.getDate();
    }
}

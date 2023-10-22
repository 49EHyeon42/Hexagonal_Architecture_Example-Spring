package dev.ehyeon.attendance.attendance.adapter.out.persistence;

import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class AttendanceEntityId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "date")
    private LocalDate localDate;
}

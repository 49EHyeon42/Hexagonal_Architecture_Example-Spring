package dev.ehyeon.attendance.attendance.application.port.in;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class SaveAttendanceByUserIdRequest {

    @NotNull
    @Positive
    private Long userId;
}

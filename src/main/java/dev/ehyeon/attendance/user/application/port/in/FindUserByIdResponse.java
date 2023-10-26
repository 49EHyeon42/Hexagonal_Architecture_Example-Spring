package dev.ehyeon.attendance.user.application.port.in;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FindUserByIdResponse {

    private final long id;
}

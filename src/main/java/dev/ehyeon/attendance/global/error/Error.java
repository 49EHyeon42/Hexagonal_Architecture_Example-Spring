package dev.ehyeon.attendance.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Error {

    BAD_REQUEST(400, "Bad Request"),

    DUPLICATED_ID(409, "Duplicated Id"),
    USER_NOT_FOUND(404, "User Not Found");

    private final int statusCode;
    private final String message;
}

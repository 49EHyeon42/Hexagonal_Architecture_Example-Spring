package dev.ehyeon.attendance.attendance.application.service;

public class DuplicatedAttendanceException extends RuntimeException {

    public DuplicatedAttendanceException() {
        super();
    }

    public DuplicatedAttendanceException(String message) {
        super(message);
    }

    public DuplicatedAttendanceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DuplicatedAttendanceException(Throwable throwable) {
        super(throwable);
    }
}

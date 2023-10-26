package dev.ehyeon.attendance.user.adapter.out.persistence;

public class DuplicatedIdException extends RuntimeException {

    public DuplicatedIdException() {
        super();
    }

    public DuplicatedIdException(String message) {
        super(message);
    }

    public DuplicatedIdException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DuplicatedIdException(Throwable throwable) {
        super(throwable);
    }
}

package dev.ehyeon.attendance.user.application.service;

public class QrCodeGenerationFailedException extends RuntimeException {

    public QrCodeGenerationFailedException() {
        super();
    }

    public QrCodeGenerationFailedException(String message) {
        super(message);
    }

    public QrCodeGenerationFailedException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public QrCodeGenerationFailedException(Throwable throwable) {
        super(throwable);
    }
}

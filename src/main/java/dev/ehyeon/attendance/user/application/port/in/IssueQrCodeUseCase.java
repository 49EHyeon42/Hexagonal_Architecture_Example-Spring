package dev.ehyeon.attendance.user.application.port.in;

public interface IssueQrCodeUseCase {

    byte[] issueQrCodeById(long id);
}

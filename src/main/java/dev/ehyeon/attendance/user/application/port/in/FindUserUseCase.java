package dev.ehyeon.attendance.user.application.port.in;

public interface FindUserUseCase {

    FindUserByIdResponse findUserById(long id);
}

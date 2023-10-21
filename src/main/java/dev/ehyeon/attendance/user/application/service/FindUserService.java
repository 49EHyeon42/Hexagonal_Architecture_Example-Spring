package dev.ehyeon.attendance.user.application.service;

import dev.ehyeon.attendance.user.application.port.in.FindUserByIdResponse;
import dev.ehyeon.attendance.user.application.port.in.FindUserUseCase;
import dev.ehyeon.attendance.user.application.port.out.FindUserPort;
import dev.ehyeon.attendance.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserService implements FindUserUseCase {

    private final FindUserPort findUserPort;

    @Override
    public FindUserByIdResponse findUserById(long id) {
        User foundUser = findUserPort.findUserById(id);

        return new FindUserByIdResponse(foundUser.getId());
    }
}

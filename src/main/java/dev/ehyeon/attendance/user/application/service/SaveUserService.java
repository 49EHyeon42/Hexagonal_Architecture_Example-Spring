package dev.ehyeon.attendance.user.application.service;

import dev.ehyeon.attendance.user.adapter.out.persistence.DuplicatedIdException;
import dev.ehyeon.attendance.user.application.port.in.SaveUserUseCase;
import dev.ehyeon.attendance.user.application.port.out.ExistUserPort;
import dev.ehyeon.attendance.user.application.port.out.SaveUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveUserService implements SaveUserUseCase {

    private final ExistUserPort existUserPort;
    private final SaveUserPort saveUserPort;

    @Override
    public void saveUserById(long id) {
        if (existUserPort.existUserById(id)) {
            throw new DuplicatedIdException();
        }

        saveUserPort.saveUserById(id);
    }
}

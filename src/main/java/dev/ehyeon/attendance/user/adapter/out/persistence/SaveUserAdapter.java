package dev.ehyeon.attendance.user.adapter.out.persistence;

import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.application.port.out.SaveUserPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveUserAdapter implements SaveUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void saveUserById(long id) {
        userJpaRepository.save(new UserEntity(id));
    }
}

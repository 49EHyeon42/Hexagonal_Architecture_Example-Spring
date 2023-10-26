package dev.ehyeon.attendance.user.adapter.out.persistence;

import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.application.port.out.ExistUserPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ExistUserAdapter implements ExistUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean existUserById(long id) {
        return userJpaRepository.existsById(id);
    }
}

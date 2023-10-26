package dev.ehyeon.attendance.user.adapter.out.persistence;

import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.application.port.out.FindUserEntityPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindUserEntityAdapter implements FindUserEntityPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserEntity findUserEntityById(long id) {
        return userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

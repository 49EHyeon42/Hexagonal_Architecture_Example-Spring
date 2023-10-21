package dev.ehyeon.attendance.user.adapter.out.persistence;

import dev.ehyeon.attendance.global.annotation.PersistenceAdapter;
import dev.ehyeon.attendance.user.application.port.out.FindUserPort;
import dev.ehyeon.attendance.user.domain.User;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindUserAdapter implements FindUserPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User findUserById(long id) {
        UserEntity foundUserEntity = userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return userMapper.userEntityToUser(foundUserEntity);
    }
}

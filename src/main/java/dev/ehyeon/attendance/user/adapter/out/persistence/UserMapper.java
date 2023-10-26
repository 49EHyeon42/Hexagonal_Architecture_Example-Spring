package dev.ehyeon.attendance.user.adapter.out.persistence;

import dev.ehyeon.attendance.global.annotation.Mapper;
import dev.ehyeon.attendance.user.domain.User;

@Mapper
public class UserMapper {

    public User userEntityToUser(UserEntity userEntity) {
        return new User(userEntity.getId());
    }
}

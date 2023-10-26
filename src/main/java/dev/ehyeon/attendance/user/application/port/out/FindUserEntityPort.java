package dev.ehyeon.attendance.user.application.port.out;

import dev.ehyeon.attendance.user.adapter.out.persistence.UserEntity;

public interface FindUserEntityPort {

    UserEntity findUserEntityById(long id);
}

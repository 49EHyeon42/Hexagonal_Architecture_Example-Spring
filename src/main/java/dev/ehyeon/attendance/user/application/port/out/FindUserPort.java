package dev.ehyeon.attendance.user.application.port.out;

import dev.ehyeon.attendance.user.domain.User;

public interface FindUserPort {

    User findUserById(long id);
}

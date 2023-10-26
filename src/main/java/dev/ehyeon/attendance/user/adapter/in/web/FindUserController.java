package dev.ehyeon.attendance.user.adapter.in.web;

import dev.ehyeon.attendance.user.application.port.in.FindUserByIdResponse;
import dev.ehyeon.attendance.user.application.port.in.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindUserController {

    private final FindUserUseCase findUserUseCase;

    @GetMapping("/user")
    public FindUserByIdResponse findUserById(long id) {
        return findUserUseCase.findUserById(id);
    }
}

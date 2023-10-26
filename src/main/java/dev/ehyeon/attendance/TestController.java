package dev.ehyeon.attendance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello, world!";
    }
}

package me.study.jpa.hello;

import lombok.RequiredArgsConstructor;
import me.study.jpa.hello.request.UserRequest;
import me.study.jpa.hello.response.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa/hello")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService service;


    @PostMapping("/users")
    public UserResponse addUser(
            @RequestBody UserRequest userRequest
    ) {
        return service.addUser(userRequest);
    }


}

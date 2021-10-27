package me.study.jpa.hello;

import me.study.jpa.hello.request.UserRequest;
import me.study.jpa.hello.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        return null;
    }

}

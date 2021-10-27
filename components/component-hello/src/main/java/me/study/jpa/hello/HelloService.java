package me.study.jpa.hello;

import me.study.jpa.hello.request.UserRequest;
import me.study.jpa.hello.response.UserResponse;

public interface HelloService {

    UserResponse addUser(UserRequest userRequest);

}

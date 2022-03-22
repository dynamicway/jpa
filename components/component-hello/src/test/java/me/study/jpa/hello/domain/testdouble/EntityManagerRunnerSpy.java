package me.study.jpa.hello.domain.testdouble;

import me.study.jpa.hello.domain.EntityManagerRunner;
import me.study.jpa.hello.domain.User;

import java.util.List;

public class EntityManagerRunnerSpy implements EntityManagerRunner {

    @Override
    public User userPersist(User user) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}

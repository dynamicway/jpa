package me.study.jpa.hello.domain.testdouble;

import me.study.jpa.hello.domain.EntityManagerRunner;
import me.study.jpa.hello.domain.User;

public class EntityManagerRunnerSpy implements EntityManagerRunner {

    @Override
    public User userPersist(User user) {
        return null;
    }

}

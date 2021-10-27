package me.study.jpa.hello.domain;

import java.util.List;

public interface EntityManagerRunner {

    User userPersist(User user);

    List<User> findAllUsers();

}

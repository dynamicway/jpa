package me.study.jpa.hello.domain;

import me.study.jpa.hello.domain.testdouble.EntityManagerRunnerSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerRunnerTest {

    private EntityManagerRunner runner;

    @BeforeEach
    void test_init() {
        runner = new EntityManagerRunnerSpy();
    }

    @Test
    void userPersist() {
        // given
        User user = User.builder()
                .name("User1")
                .build();

        // when


        // then

    }
}
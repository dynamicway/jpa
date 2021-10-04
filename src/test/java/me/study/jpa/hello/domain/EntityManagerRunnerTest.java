package me.study.jpa.hello.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DataJpaTest
class EntityManagerRunnerTest {

    private EntityManagerRunner runner;

    @BeforeEach
    void test_init() {
        runner = new EntityManagerRunnerImpl();
    }

    @Test
    void userPersist() {
        // given
        User user = User.builder()
                .name("User1")
                .build();

        // when
        User userPersist = runner.userPersist(user);

        // then
        assertSoftly(s -> {
            s.assertThat(userPersist.getId()).isNotNull();
            s.assertThat(userPersist.getName()).isEqualTo(user.getName());
        });

    }
}
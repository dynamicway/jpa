package me.study.jpa.hello.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
class EntityManagerRunnerTest {

    @Autowired
    private EntityManagerRunner runner;

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

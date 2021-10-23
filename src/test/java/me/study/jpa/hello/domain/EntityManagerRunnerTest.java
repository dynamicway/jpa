package me.study.jpa.hello.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@Transactional
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

    @Test
    @DisplayName("모든 유저를 가져온다")
    void findAllUsers() {
        List<User> givenUsers = List.of(User.builder()
                        .name("User1")
                        .build(),
                User.builder()
                        .name("User2")
                        .build(),
                User.builder()
                        .name("User3")
                        .build()
        );
        givenUsers.forEach(runner::userPersist);

        // when
        List<User> foundUsers = runner.findAllUsers();

        // then
        assertThat(foundUsers.stream().map(User::getName))
                .containsExactlyElementsOf(givenUsers.stream().map(User::getName).collect(Collectors.toList()));

    }
}

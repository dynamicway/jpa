package me.study.jpa.hello.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@RequiredArgsConstructor
public class EntityManagerRunnerImpl implements EntityManagerRunner {

    @PersistenceUnit
    private final EntityManagerFactory emf;

    @Override
    public User userPersist(User user) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(user);
        User persistedUser = em.find(User.class, 1L);

        em.close();

        transaction.commit();

        return persistedUser;
    }

}

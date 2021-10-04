package me.study.jpa.hello.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerRunnerImpl implements EntityManagerRunner {

    @PersistenceContext
    EntityManager em;

    @Override
    public User userPersist(User user) {
        em.persist(user);
        em.flush();
        return em.find(User.class, 1L);
    }

}

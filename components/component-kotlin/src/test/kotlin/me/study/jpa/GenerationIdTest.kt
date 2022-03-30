package me.study.jpa

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManagerFactory

@DataJpaTest
internal class GenerationIdTest @Autowired constructor(
    private val entityManagerFactory: EntityManagerFactory
) {

    @Test
    fun getId_withReflection_when_callsPersist_before_transaction_committed() {
        val entityManager = entityManagerFactory.createEntityManager()
        val order = Order()
        entityManager.transaction.begin()
        entityManager.persist(order)

        assertThat(order.id).isNotNull

        entityManager.transaction.commit()
        entityManager.close()
    }

}

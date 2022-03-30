package me.study.jpa

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory

@DataJpaTest
internal class GenerationIdTest @Autowired constructor(
    private val entityManagerFactory: EntityManagerFactory
) {

    private lateinit var entityManager: EntityManager

    @BeforeEach
    internal fun setUp() {
        entityManager = entityManagerFactory.createEntityManager()
    }

    @Test
    fun getId_with_reflection_when_calls_Persist_before_transaction_committed() {
        val order = Order()
        entityManager.transaction.begin()
        entityManager.persist(order)

        assertThat(order.id).isNotNull

        entityManager.transaction.commit()
        entityManager.close()
    }

    @Test
    fun persist_without_transaction_not_throw_any_exception() {
        val order = Order()

        assertThatCode { entityManager.persist(order) }
            .doesNotThrowAnyException()

        assertThat(order.id).isNull()
        assertThat(entityManager.transaction.isActive).isFalse
    }

}

package me.study.jpa

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
internal class GenerationIdTest @Autowired constructor(
    private val entityManagerFactory: EntityManagerFactory
) {

    private lateinit var entityManager: EntityManager

    @BeforeEach
    internal fun setUp() { entityManager = entityManagerFactory.createEntityManager() }

    @AfterEach
    internal fun afterEach() { entityManager.close() }

    @Test
    fun getId_with_reflection_when_calls_Persist_before_transaction_committed() {
        val order = Order()
        entityManager.transaction.begin()
        entityManager.persist(order)

        assertThat(order.id).isNotNull

        entityManager.transaction.commit()
    }

    @Test
    fun persist_without_transaction_not_throw_any_exception() {
        val order = Order()
        order.name = "히히"

        assertThatCode { entityManager.persist(order) }
            .doesNotThrowAnyException()

        assertThat(entityManager.transaction.isActive).isFalse
        entityManager.createQuery("SELECT id, name FROM Order WHERE name = '히히'")
            .resultList.forEach {
                if (it is Order)
                    println(it.name)
            }
    }

    @Test
    fun persist_without_transaction_not_insert_entity_to_database() {
        val order = Order()
        val givenOrderName = "this is my name"
        order.name = givenOrderName

        entityManager.persist(order)
        val orders = entityManager.createQuery("SELECT id, name FROM Order WHERE name = '히히'")
            .resultList

        assertThat(order.id).isNull()
        assertThat(order.name).isEqualTo(givenOrderName)
        assertThat(entityManager.transaction.isActive).isFalse
        assertThat(orders).isEmpty()
    }

    @Test
    fun find_without_transaction() {
        entityManager.transaction.begin()
        entityManager.persist(Order())
        entityManager.transaction.commit()
        entityManager.clear()

        assertThat(entityManager.find(Order::class.java, 1L)).isNotNull
    }

}

package me.study.jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManagerFactory

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
internal class CascadeTest @Autowired constructor(
    private val entityManagerFactory: EntityManagerFactory
) {

    @Test
    fun test() {
        entityManagerFactory.createEntityManager()
    }

}
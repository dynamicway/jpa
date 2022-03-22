package me.study.jpa

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "ORDERS")
class Order (
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id_: Long? = null
) {

    private val orderItems = OrderItems()

    @Embeddable
    private class OrderItems {

        @OneToMany(mappedBy = "order")
        private val orderItems = mutableListOf<OrderItem>()

    }

}

package me.study.jpa

import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class Order(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    var name: String = ""

    private val orderItems = OrderItems()

    @Embeddable
    private class OrderItems {

        @OneToMany(mappedBy = "order")
        private val orderItems = mutableListOf<OrderItem>()

    }

}

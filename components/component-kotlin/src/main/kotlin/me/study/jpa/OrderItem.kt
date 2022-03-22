package me.study.jpa

import javax.persistence.*
import javax.persistence.FetchType.*

@Entity
class OrderItem(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id_: Long? = null,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private var order: Order? = null
)

package me.study.jpa.inflearn.delivery;

import me.study.jpa.inflearn.member.Address;
import me.study.jpa.inflearn.order.Order;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    private Status status;

    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private Order order;

    public enum Status {

    }
}

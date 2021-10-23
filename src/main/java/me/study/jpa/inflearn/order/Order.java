package me.study.jpa.inflearn.order;

import lombok.Getter;
import me.study.jpa.inflearn.delivery.Delivery;
import me.study.jpa.inflearn.member.Member;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    private ZonedDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ORDER,
        CANCEL
    }
}

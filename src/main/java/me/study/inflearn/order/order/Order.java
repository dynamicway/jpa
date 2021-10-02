package me.study.inflearn.order.order;

import lombok.Getter;
import me.study.inflearn.order.member.Member;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "MEMBER_ID")
    private Member member;

    private ZonedDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private Status orderStatus;

    public enum Status {
        ORDER,
        CANCEL
    }
}

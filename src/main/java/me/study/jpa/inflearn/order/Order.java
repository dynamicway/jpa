package me.study.jpa.inflearn.order;

import lombok.Getter;
import me.study.jpa.inflearn.member.Member;

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
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private ZonedDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ORDER,
        CANCEL
    }
}

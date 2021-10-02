package me.study.inflearn.order.order;

import me.study.inflearn.order.member.Member;

import java.time.ZonedDateTime;

public class Order {
    private Long id;
    private Member member;
    private ZonedDateTime orderDate;
    private Status orderStatus;

    public enum Status {

    }
}

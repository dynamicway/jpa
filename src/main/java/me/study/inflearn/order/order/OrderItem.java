package me.study.inflearn.order.order;

import lombok.Getter;
import me.study.inflearn.order.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
@Getter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @Column(name = "ITEM_ID")
    private Item item;

    private Integer price;

    private Integer count;
}

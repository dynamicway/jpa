package me.study.jpa.inflearn.order;

import lombok.Getter;
import me.study.jpa.inflearn.item.Item;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "ORDER_ITEM")
@Getter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private Integer price;

    private Integer count;
}

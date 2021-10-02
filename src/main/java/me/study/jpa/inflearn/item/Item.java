package me.study.jpa.inflearn.item;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;
}

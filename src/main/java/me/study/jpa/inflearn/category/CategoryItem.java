package me.study.jpa.inflearn.category;

import me.study.jpa.inflearn.item.Item;

import javax.persistence.*;

@Entity
public class CategoryItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

}

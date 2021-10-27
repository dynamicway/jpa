package me.study.jpa.inflearn.category;

import me.study.jpa.inflearn.item.Item;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class CategoryItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

}

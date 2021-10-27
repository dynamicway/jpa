package me.study.jpa.inflearn.item;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Book extends Item{

    private String author;

    private String isbn;

}

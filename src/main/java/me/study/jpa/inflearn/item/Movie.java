package me.study.jpa.inflearn.item;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Movie extends Item{

    private String director;

    private String actor;

}

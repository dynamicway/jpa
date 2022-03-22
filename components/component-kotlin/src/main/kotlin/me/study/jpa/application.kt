package me.study.jpa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinJpaApplication

fun main(args: Array<String>) {
    runApplication<KotlinJpaApplication>(*args)
}
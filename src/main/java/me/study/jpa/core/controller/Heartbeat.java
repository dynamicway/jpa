package me.study.jpa.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heartbeat")
public class Heartbeat {

    @GetMapping
    public String heartbeat() {
        return "OK";
    }
}

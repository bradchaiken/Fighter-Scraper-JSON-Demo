package com.chaikenintegrations.spring.tutorial.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BoxrecController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/boxrec")
    public Boxrec boxrec(
                @RequestParam(value="name") String name,
                @RequestParam(value="boxrecId") Integer boxrecId) {

        Boxrec boxrec = new Boxrec(String.format(template, name), boxrecId);

        return boxrec;
    }
}
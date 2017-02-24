package com.chaikenintegrations.spring.tutorial.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SherdogController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/sherdog")
    public Sherdog boxrec(
            @RequestParam(value="name") String name,
            @RequestParam(value="sherdogId") Integer sherdogId) {

        Sherdog sherdog = new Sherdog(String.format(template, name), sherdogId);

        return sherdog;
    }
}
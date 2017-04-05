//curl --request POST \
//        --url 'http://localhost:8080/sherdog?name=Your-Name&sherdogId=1437' \
//        --header 'authorization: Basic VVNqdkRpOFVCaWJRQjVHUmROQmZaNzcxOmEzNDEwZDg3LWE4ZmUtNDdhYS04ZGY4LTg5NGM0ODIyN2RmMw==' \
//        --header 'cache-control: no-cache' \
//        --header 'postman-token: bab70542-fd6a-7eef-f58c-375f5a1f9b48'

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
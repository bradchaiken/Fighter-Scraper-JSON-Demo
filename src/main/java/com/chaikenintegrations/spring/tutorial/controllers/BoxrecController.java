//curl --request POST \
//        --url 'http://localhost:8080/boxrec?name=Your-Name&boxrecId=1437' \
//        --header 'authorization: Basic VVNqdkRpOFVCaWJRQjVHUmROQmZaNzcxOmEzNDEwZDg3LWE4ZmUtNDdhYS04ZGY4LTg5NGM0ODIyN2RmMw==' \
//        --header 'cache-control: no-cache' \
//        --header 'postman-token: dba27cb8-245d-5f5d-6516-2cdbc8ad0557'

package com.chaikenintegrations.spring.tutorial.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BoxrecController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/boxrec")
    public Boxrec boxrec(
                @RequestParam(value="name") String name,
                @RequestParam(value="boxrecId") Integer boxrecId) {

        Boxrec boxrec = new Boxrec(String.format(template, name), boxrecId);

        return boxrec;
    }
}
package com.chaikenintegrations.spring.tutorial.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chaikenintegrations.spring.tutorial.mail.MailSender;
import com.chaikenintegrations.spring.tutorial.mail.MockMailSender;
import javax.annotation.Resource;

@RestController
public class MailController {

    @Resource
    private MailSender mailSender = new MockMailSender();

    @RequestMapping("/mail") public String sendMail() {
        mailSender.send("abc@example.com", "Some subject", "the content");
        return "Mail sent";
    }

}
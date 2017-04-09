package com.chaikenintegrations.spring.tutorial.mail;

import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class MockMailSender implements MailSender {

    private static final org.apache.juli.logging.Log log = LogFactory.getLog(MockMailSender.class);

    @Override
    public void send(String to, String subject, String body) {
        log.info("Sending mail to " + to);
        log.info("Subject: " + subject); log.info("Body: " + body);
    }

}
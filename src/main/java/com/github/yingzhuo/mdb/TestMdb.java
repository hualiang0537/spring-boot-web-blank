package com.github.yingzhuo.mdb;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import javax.jms.TextMessage;


@Component
public class TestMdb {

    @JmsListener(destination = "testQueue")
    public void doWork(TextMessage textMessage, Session session) throws Throwable {
        System.out.println(textMessage.getText());
    }

}

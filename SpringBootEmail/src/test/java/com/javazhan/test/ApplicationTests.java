package com.javazhan.test;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yando on 2017/11/14.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void testSendSimple() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发送者
        message.setFrom("1360330566@qq.com");
        // 接收者
        message.setTo("2383839585@qq.com");
        //邮件主题
        message.setSubject("标题：测试标题");
        // 邮件内容
        message.setText("测试内容部份");
        javaMailSender.send(message);
    }
}

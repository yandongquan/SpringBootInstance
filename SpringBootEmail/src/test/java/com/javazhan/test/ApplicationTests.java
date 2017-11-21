package com.javazhan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by yando on 2017/11/14.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    //读取配置文件中的参数
    @Value("${spring.mail.username}")
    private String sender;

    private static final String recipient = "yandongquanlove@163.com" ;
    /**
     * 发送简单文本邮件
     */
    @Test
    public void sendSimpleEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发送者
        message.setFrom(sender);
        // 接收者
        message.setTo(recipient);
        //邮件主题
        message.setSubject("测试标题");
        // 邮件内容
        message.setText("骚扰邮件勿回");
        javaMailSender.send(message);
    }

    /**
     * 发送Html邮件
     */
    @Test
    public void sendHtmlEmail() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(recipient);
            helper.setSubject("主题：HTML邮件");
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
        } catch (MessagingException e) {
            throw new RuntimeException("Messaging  Exception !", e);
        }
        javaMailSender.send(message);
    }

    /**
     * 发送附件邮件
     */
    @Test
    public void sendAttachmentEmail() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(recipient);
            helper.setSubject("主题：附件邮件");
            helper.setText("有附件，请查收");
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/images/avatar.jpg"));
            //加入邮件
            helper.addAttachment("图片.jpg", file);
        } catch (MessagingException e) {
            throw new RuntimeException("Messaging  Exception !", e);
        }
        javaMailSender.send(message);
    }

    /**
     * 发送模板邮件
     */
    @Test
    public void sendInlineMail() {

    }

}

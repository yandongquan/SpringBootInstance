package com.javazhan.controller;

import com.google.gson.Gson;
import com.javazhan.vo.RequestData;
import com.javazhan.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by yando on 2017/11/22.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String sender;

    private RequestData requestData = new RequestData() ;

    public static Map<String, User> map = new HashMap<String, User>();

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user) {
        for(User u : map.values()) {
            if(u!=null && u.getUserPass().equals(user.getUserPass()) && u.getUserEmail().equals(user.getUserEmail())) {
                if(u.getState()==0) {
                    requestData.setCode("9999");
                    requestData.setState("500");
                    requestData.setMessage("请前往"+user.getUserEmail()+"邮箱激活");
                    return new Gson().toJson(requestData);
                }
                requestData.setMessage("登录成功");
                return new Gson().toJson(requestData);
            }
        }
        requestData.setCode("9999");
        requestData.setState("500");
        requestData.setMessage("邮箱或者密码错误");
        return new Gson().toJson(requestData);

    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user) {
        map.put(user.getUserId(), user);
        // 发送注册邮件
        sendTemplateMail(user.getUserEmail(), user.getUserId());
        requestData.setMessage("注册成功, 快去激活");
        return new Gson().toJson(requestData);
    }
    @RequestMapping(value = "forget", method = RequestMethod.POST)
    public String forget(User user) {
        for(User u : map.values()) {
            if(u!=null || u.getUserEmail()== user.getUserEmail()) {
                u.setUserPass("6666");
                map.remove(u.getUserId());
                map.put(u.getUserId(), u);
                requestData.setMessage("密码已经重置，快去查看你的邮箱");
                sendSimpleEmail(u.getUserEmail(), "您好，您密码已重置，初始密码：6666，为了你的安全请尽快修改密码。");
                return new Gson().toJson(requestData);
            }
        }
        requestData.setCode("9999");
        requestData.setState("500");
        requestData.setMessage("无效邮箱");
        return new Gson().toJson(requestData);
    }
    @RequestMapping(value = "activation/{userId}", method = RequestMethod.GET)
    public void activation(@PathVariable String userId, HttpServletResponse response) throws IOException {
        User user = map.get(userId);
        if(user!=null) {
            user.setState(1);
            map.remove(user.getUserId());
            map.put(user.getUserId(), user);
        }
        response.sendRedirect("../../login.html");
    }

    public void sendSimpleEmail(String recipient,String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发送者
        message.setFrom(sender);
        // 接收者
        message.setTo(recipient);
        // 邮件主题
        message.setSubject("Java资源分享网密码重置邮件");
        // 邮件内容
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendTemplateMail(String recipient,String userId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(recipient);
            helper.setSubject("Java资源分享网验证邮件");
            Context context = new Context();
            context.setVariable("id", userId);
            String emailContent = templateEngine.process("emailTemplate", context);
            helper.setText(emailContent, true);
        } catch (MessagingException e) {
            throw new RuntimeException("Messaging  Exception !", e);
        }
        javaMailSender.send(message);
    }

}

package com.lmk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
public class SendMail {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/send")
    public String sendEmail(){
        try {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo("22@qq.com");
            mailMessage.setSubject("一封简单的邮件");
            mailMessage.setText("使用Spring Boot发送简单邮件。");
            javaMailSender.send(mailMessage);
            return "发送成功";
        } catch (MailException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

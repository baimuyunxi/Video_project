package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTestApplicationTests {

    
    @Autowired
    JavaMailSenderImpl mailSender;
    
    @Test
    void contextLoads() {
        // 一个简单的邮件
        SimpleMailMessage MailMessage = new SimpleMailMessage();
        MailMessage.setSubject("白木云曦");
        MailMessage.setText("谢谢！");
        MailMessage.setTo("1365402987@qq.com");
        MailMessage.setFrom("1365402987@qq.com");
        mailSender.send(MailMessage);
    }

    @Test
    void contextLoads1() throws MessagingException {
        // 一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("白木云曦");
        helper.setText("<p style='color:red'>123</p>",true);
        helper.addAttachment("1.jpg",new File("/*地址*/"));
        helper.setTo("1365402987@qq.com");
        helper.setFrom("1365402987@qq.com");
        mailSender.send(mimeMessage);
    }

    /**
    * @param html :
    * @throws MessagingException
    */
    public void sendMail(Boolean html,String subject,String text) throws MessagingException{
        // 一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject(subject);
        helper.setText(text,true);
        helper.addAttachment("1.jpg",new File("/*地址*/"));
        helper.setTo("1365402987@qq.com");
        helper.setFrom("1365402987@qq.com");
        mailSender.send(mimeMessage);
    }

}

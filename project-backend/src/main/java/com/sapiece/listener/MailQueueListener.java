package com.sapiece.listener;

/**
 * @Author SAPiece
 * @Create 2023-12-29 13:44
 * @Package com.sapiece.listener
 * @Project GraduationDesign
 * @Filename MailQueueListener
 * @Version 1.0
 */

import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 用于处理邮件发送的消息队列监听器
 */
@Component
@RabbitListener(queues = "mail")
public class MailQueueListener {

    @Resource
    JavaMailSender sender;

    @Value("${spring.mail.username}")
    String username;

    /**
     * 处理邮件发送
     * @param data 邮件信息
     */
    @RabbitHandler
    public void sendMailMessage(Map<String, Object> data) {
        String email =(String) data.get("email");
        Integer code = (Integer) data.get("code");
        String type = (String) data.get("type");
        SimpleMailMessage message = switch (type) {
            case "register" ->
                    createMessage("欢迎注册该网站",
                            "您的邮件注册验证码为: "+code+"，有效时间3分钟，为了保障您的账户安全，请勿向他人泄露验证码信息。",
                            email);
            case "reset" ->
                    createMessage("您的密码重置邮件",
                            "你好，您正在执行重置密码操作，验证码: "+code+"，有效时间3分钟，如非本人操作，请忽略此消息。",
                            email);
            default -> null;
        };
        if(message == null) return;
        sender.send(message);
    }

    /**
     * 快速封装简单邮件消息实体
     * @param title 标题
     * @param content 内容
     * @param email 收件人
     * @return 邮件实体
     */
    private SimpleMailMessage createMessage(String title, String content, String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(title);
        message.setText(content);
        message.setTo(email);
        message.setFrom(username);
        return message;
    }
}

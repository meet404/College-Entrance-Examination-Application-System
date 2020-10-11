package com.wzq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author wzq
 * @date 2020/10/10
 * @email 158957716@qq.com
 */
@Service
public class EmailService {

	/**
	 * 设置发件人
	 */
	private static final String sendEmail = "yourhero666@126.com";

	@Autowired
	JavaMailSenderImpl mailSender;

	/**
	 * 封装邮件发送，开启异步加载
	 *
	 * @param text   邮件内容
	 * @param sendTo 收件人
	 * @throws MessagingException
	 */
	@Async
	public void sendMail(String subject, String text, String sendTo) throws MessagingException {
		System.out.println("==========开始邮件发送==========");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject(subject);
		helper.setText(text, true);
		helper.setTo(sendTo);
		helper.setFrom(sendEmail);
		mailSender.send(mimeMessage);
		System.out.println("==========邮件发送成功==========");
	}
}

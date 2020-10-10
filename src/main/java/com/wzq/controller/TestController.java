package com.wzq.controller;

import com.wzq.pojo.User;
import com.wzq.service.EmailService;
import com.wzq.service.UserService;
import com.wzq.utils.GetHtmlText;
import com.wzq.utils.GuuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	JavaMailSenderImpl mailSender;

	@RequestMapping("/test")
	public String test() {
		return "admin/index";
	}

	@RequestMapping("/test1")
	public String test1() {
		return "admin/pages/forms/forms-filling";
	}

	@RequestMapping("/test2")
	public String test2() {
		return "login/register222";
	}


	/**
	 * 邮件发送
	 *
	 * @param text   获取的验证码
	 * @param sendTo 发送给谁
	 * @throws MessagingException
	 */
	@Async
	public void sendMail(String text, String sendTo) throws MessagingException {
		System.out.println("开始邮件发送~");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject("邮件激活验证");
		helper.setText(text, true);
		helper.setTo(sendTo);
		helper.setFrom("yourhero666@126.com");
		mailSender.send(mimeMessage);
		System.out.println("邮件发送成功~");
	}


	@RequestMapping("/addUser3")
	public String addUser3(User user) throws MessagingException {
		user.setId(GuuidUtil.getUUID());
		userService.addUser(user);
		String uid = String.valueOf(user.getId());
		String email = user.getEmail();
		String subject = GetHtmlText.subject();
		String text = GetHtmlText.text(uid);
		emailService.sendMail(subject, text, email);
		return "user/page1";
	}
}

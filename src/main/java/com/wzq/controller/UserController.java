package com.wzq.controller;

import com.wzq.pojo.User;
import com.wzq.service.EmailService;
import com.wzq.service.UserService;
import com.wzq.utils.GetHtmlText;
import com.wzq.utils.GuuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

/**
 * @author wzq
 * @date 2020/10/10
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	/**
	 * 前往注册页面
	 *
	 * @return
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "login/register";
	}


	@RequestMapping("/addUser")
	public String addUser(User user, Model model) throws MessagingException {

		String username1 = user.getUsername();
		String email1 = user.getEmail();
		if (userService.findUserByName(username1) != null) {
			System.out.println("用户已存在");
			model.addAttribute("msg", "用户名已被注册！");
			return "login/register";
		} else if (userService.findUserByEmail(email1) != null) {
			model.addAttribute("msg", "邮箱已被使用！");
			System.out.println("邮箱已被使用");
			return "login/register";
		} else {
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

}

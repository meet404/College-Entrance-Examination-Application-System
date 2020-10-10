package com.wzq.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * 前往登陆页面
	 *
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login/login";
	}

	/**
	 * 执行登陆请求
	 *
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String username, String password, Model model) {
		//获取当前用户
		Subject subject = SecurityUtils.getSubject();
		//封装用户登陆数据
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);//执行登陆
			return "redirect:/";
		} catch (UnknownAccountException e) {
			model.addAttribute("msg", "用户名错误");
			return "login/login";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("msg", "密码错误");
			return "login/login";
		}
	}

}

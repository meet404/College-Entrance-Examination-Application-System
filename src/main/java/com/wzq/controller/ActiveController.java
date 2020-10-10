package com.wzq.controller;

import com.wzq.pojo.User;
import com.wzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzq
 * @date 2020/10/10
 * @email 158957716@qq.com
 */
@Controller
public class ActiveController {

	@Autowired
	private UserService userService;

	/**
	 * TODO:此处可能存在安全风险
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/active/{id}")
	public String activeUser(@PathVariable("id") long id) {
		if (String.valueOf(id).length() != 18) {
			return "/error/404";
		} else {
			User user = userService.findUserById(id);
			if (user == null) {
				return "/user/page3";
			} else {
				if (user.getUserStatus() == 2) {
					user.setUserStatus(0);
					userService.activeUser(user);
					return "/user/page2";
				} else {
					return "/user/page3";
				}
			}
		}
	}
}

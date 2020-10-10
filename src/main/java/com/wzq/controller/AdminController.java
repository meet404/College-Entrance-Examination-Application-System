package com.wzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzq
 * @date 2020/10/6
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/index")
	public String adminPage(){
		return "admin/index";
	}
}

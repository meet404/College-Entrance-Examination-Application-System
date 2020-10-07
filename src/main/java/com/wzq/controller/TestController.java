package com.wzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/test")
	public String test(){
		return "admin/index";
	}

	@RequestMapping("/test1")
	public String test1(){
		return "admin/pages/forms/forms-filling";
	}
}

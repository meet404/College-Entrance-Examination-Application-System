package com.wzq.controller;

import com.wzq.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
@Controller
public class IndexController {

	@Autowired
	public SchoolService schoolService;

	/**
	 * 跳转首页
	 */
	@RequestMapping("/")
	public String index(Model model) {
		int count = schoolService.count();
		model.addAttribute("count",count);
		return "index";
	}

}

package com.wzq.controller;

import com.wzq.pojo.School;
import com.wzq.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/page")
public class PageController {

	@Autowired
	public SchoolService schoolService;

	/**
	 * 跳转到专业页面
	 */
	@RequestMapping("/searchMajor")
	public String searchMajor() {
		return "/user/searchMajor";
	}

	/**
	 * 跳转查大学页面，分页查询
	 */
	@RequestMapping("/searchSchoolPage/{pages}")
	public String searchSchool(@PathVariable("pages") int pages, Model model) {
		List<School> schoolListUser = schoolService.findAllPages(pages);
		model.addAttribute("schoolListUser",schoolListUser);
		int count = schoolService.count();
		model.addAttribute("count",count);
		model.addAttribute("pages",pages);
		if (count%15 != 0 ){
			model.addAttribute("allPages",count/15 + 1);
		}else {
			model.addAttribute("allPages",count/15);
		}
		return "user/searchSchool";
	}

}

package com.wzq.controller;

import com.wzq.pojo.Major;
import com.wzq.pojo.School;
import com.wzq.service.MajorService;
import com.wzq.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/4
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/major")
public class MajorController {

	@Autowired
	private MajorService majorService;

	@Autowired
	private SchoolService schoolService;

	@RequestMapping("/findAll")
	public String findAll(Model model){
		List<Major> list = majorService.findAll();
		model.addAttribute("list",list);
		return "admin/pages/tables/majors-list";
	}

	@RequestMapping("/toAdd")
	public String toAdd(Model model){
		List<School> schools = schoolService.findAll();
		model.addAttribute("schools",schools);
		return "admin/pages/forms/majors-form";
	}

	@RequestMapping("/add")
	public String addMajor(Major major){
		majorService.addMajor(major);
		return "redirect:/major/findAll";
	}

}

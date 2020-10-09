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
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	protected SchoolService schoolService;

	/**
	 * 跳转查大学页面，分页查询
	 */
	@RequestMapping("/schoolList/{pages}")
	public String searchSchool(@PathVariable("pages") int pages, Model model) {
		List<School> schoolList = schoolService.findAllPages(pages);
		model.addAttribute("schoolList",schoolList);
		int count = schoolService.count();
		model.addAttribute("count",count);
		model.addAttribute("pages",pages);
		if (count%15 != 0 ){
			model.addAttribute("allPages",count/15 + 1);
		}else {
			model.addAttribute("allPages",count/15);
		}
		return "admin/pages/tables/school-list";
	}

	@RequestMapping("/toAdd")
	public String toAddSchool() {
		return "admin/pages/forms/forms-filling";
	}

	@RequestMapping("/add")
	public String addSchool(School school) {
		schoolService.addSchool(school);
		return "redirect:/school/schoolList/1";
	}

	@RequestMapping("/delete/{id}")
	private String deleteSchool(@PathVariable("id") long id) {
		schoolService.deleteSchool(id);
		return "redirect:/school/schoolList/1";
	}

	@RequestMapping("/findByName")
	public String findByName(String name, Model model) {
		List<School> schoolList = schoolService.findSchoolByName(name);
		model.addAttribute("schoolList", schoolList);
		return "admin/pages/tables/school-list";
	}

	@RequestMapping("/toUpdate/{id}")
	public String toUpdate(@PathVariable("id") long id, Model model) {
		School school = schoolService.findSchoolById(id);
		model.addAttribute("school", school);
		return "admin/pages/forms/update-forms";
	}

	@RequestMapping("/update")
	public String updateUser(School school) {
		schoolService.updateSchool(school);
		return "redirect:/school/schoolList/1";
	}

}

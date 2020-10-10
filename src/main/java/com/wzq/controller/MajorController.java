package com.wzq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzq.pojo.Major;
import com.wzq.pojo.School;
import com.wzq.service.MajorService;
import com.wzq.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * 查找全部信息
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Major> list = majorService.findAll();
		model.addAttribute("list", list);
		return "admin/pages/tables/majors-list";
	}

	/**
	 * 前往更新页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		List<School> schools = schoolService.findAll();
		model.addAttribute("schools", schools);
		return "admin/pages/forms/majors-form";
	}

	/**
	 * 添加信息
	 *
	 * @param major
	 * @return
	 */
	@RequestMapping("/add")
	public String addMajor(Major major) {
		majorService.addMajor(major);
		return "redirect:/major/findAll";
	}

	/**
	 * 携带更新数据前往更新页面
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdate/{id}")
	public String toUpdate(@PathVariable("id") long id, Model model) {
		List<School> schools = schoolService.findAll();
		model.addAttribute("schools", schools);
		Major major = majorService.findMajorById(id);
		model.addAttribute("major", major);
		return "admin/pages/forms/majors-update-form";
	}

	/**
	 * 更新专业信息
	 *
	 * @param major
	 * @return
	 */
	@RequestMapping("/update")
	public String updateUser(Major major) {
		majorService.addMajor(major);
		return "redirect:/major/findAll";
	}

	/**
	 * 通过学校名字查找相关专业的模糊查询
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/findByName")
	public String findByName(String name, Model model) {
		List<Major> list = majorService.findAllByName(name);
		model.addAttribute("list", list);
		return "admin/pages/tables/majors-list";
	}

	/**
	 * 分页查询
	 * TODO:严重bug
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/majorList")
	public String findAllByPage(Model model) {
		PageHelper.startPage(1, 1);
		List<Major> all = majorService.findAll();
		PageInfo<Major> list = new PageInfo<Major>(all);
		model.addAttribute("list", list);
		return "admin/pages/tables/majors-list";
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	private String deleteSchool(@PathVariable("id") long id) {
		majorService.deleteMajor(id);
		return "redirect:/major/findAll";
	}

}

package com.wzq.controller;

import com.wzq.pojo.School;
import com.wzq.pojo.Score;
import com.wzq.service.SchoolService;
import com.wzq.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/5
 * @email 158957716@qq.com
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private SchoolService schoolService;

	@RequestMapping("/findAllBySchoolId/{id}")
	public String findAllBySchoolId(@PathVariable("id") long id, Model model) {
		List<Score> scoreList = scoreService.findAllBySchoolId(id);
		School school = schoolService.findSchoolById(id);
		model.addAttribute("scoreList", scoreList);
		model.addAttribute("school", school);
		return "admin/pages/tables/scores-list";
	}
}

package com.wzq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzq.mapper.SchoolMapper;
import com.wzq.pojo.School;
import com.wzq.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolMapper schoolMapper;

	@Override
	public List<School> findAll() {
		return schoolMapper.selectList(null);
	}

	@Override
	public int addSchool(School school) {
		return schoolMapper.insert(school);
	}

	@Override
	public int deleteSchool(long id) {
		return schoolMapper.deleteById(id);
	}

	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
	@Override
	public List<School> findSchoolByName(String name) {
		QueryWrapper<School> wrapper = new QueryWrapper<>();
		wrapper.like("school_name", name);
		return schoolMapper.selectList(wrapper);
	}

	@Override
	public School findSchoolById(long id) {
		return schoolMapper.selectById(id);
	}

	@Override
	public int updateSchool(School school) {
		return schoolMapper.updateById(school);
	}

	@Override
	public int count() {
		return schoolMapper.count();
	}

	@Override
	public List<School> findAllPages(int pages) {
		Page<School> page = new Page<>(pages,15);
		schoolMapper.selectPage(page,null);
		List<School> schools = page.getRecords();
		return schools;
	}


}

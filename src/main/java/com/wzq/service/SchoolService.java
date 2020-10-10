package com.wzq.service;

import com.wzq.pojo.School;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
public interface SchoolService {

	/**
	 * 返回校园信息列表
	 *
	 * @return
	 */
	List<School> findAll();

	/**
	 * 添加学校
	 *
	 * @param school
	 * @return
	 */
	int addSchool(School school);

	/**
	 * 删除条目
	 *
	 * @param id
	 * @return
	 */
	int deleteSchool(long id);

	/**
	 * 模糊查询
	 *
	 * @param name
	 * @return
	 */
	List<School> findSchoolByName(String name);

	/**
	 * 通过id查找
	 *
	 * @param id
	 * @return
	 */
	School findSchoolById(long id);

	/**
	 * 通过id更新
	 *
	 * @param school
	 * @return
	 */
	int updateSchool(School school);

	/**
	 * 统计学校数目
	 *
	 * @return
	 */
	int count();

	/**
	 * 分页查询
	 *
	 * @return
	 */
	List<School> findAllPages(int pages);

}

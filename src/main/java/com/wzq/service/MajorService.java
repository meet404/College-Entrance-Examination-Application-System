package com.wzq.service;

import com.wzq.pojo.Major;
import com.wzq.pojo.School;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/4
 * @email 158957716@qq.com
 */
public interface MajorService {

	/**
	 * 查找全部专业
	 *
	 * @return
	 */
	List<Major> findAll();

	/**
	 * 添加新的专业信息
	 *
	 * @param major
	 * @return
	 */
	int addMajor(Major major);

	/**
	 * 通过ip查找
	 *
	 * @param id
	 * @return
	 */
	Major findMajorById(long id);

	/**
	 * 通过id更新
	 *
	 * @param major
	 * @return
	 */
	int updateMajor(Major major);

	/**
	 * 模糊查询
	 *
	 * @param name
	 * @return
	 */
	List<Major> findAllByName(String name);

	/**
	 * 统计
	 * @return
	 */
	int count();

	/**
	 * 删除条目
	 *
	 * @param id
	 * @return
	 */
	int deleteMajor(long id);
}

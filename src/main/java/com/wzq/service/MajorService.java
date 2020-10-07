package com.wzq.service;

import com.wzq.pojo.Major;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/4
 * @email 158957716@qq.com
 */
public interface MajorService{

	List<Major> findAll();

	int addMajor(Major major);

}

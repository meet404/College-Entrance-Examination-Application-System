package com.wzq.service.impl;

import com.wzq.mapper.MajorMapper;
import com.wzq.pojo.Major;
import com.wzq.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/4
 * @email 158957716@qq.com
 */
@Service
public class MajorServiceImpl implements MajorService {

	@Autowired
	private MajorMapper majorMapper;

	@Override
	public List<Major> findAll() {
		return majorMapper.findAll();
	}

	@Override
	public int addMajor(Major major) {
		return majorMapper.insert(major);
	}

}

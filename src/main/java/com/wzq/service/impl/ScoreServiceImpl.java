package com.wzq.service.impl;

import com.wzq.mapper.ScoreMapper;
import com.wzq.pojo.Score;
import com.wzq.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/5
 * @email 158957716@qq.com
 */
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public List<Score> findAllBySchoolId(long id) {
		return scoreMapper.findAllBySchoolId(id);
	}

}

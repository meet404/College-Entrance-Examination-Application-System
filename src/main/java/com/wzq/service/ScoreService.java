package com.wzq.service;

import com.wzq.pojo.Score;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/5
 * @email 158957716@qq.com
 */
public interface ScoreService {

	List<Score> findAllBySchoolId(long id);

}

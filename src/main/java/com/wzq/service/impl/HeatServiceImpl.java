package com.wzq.service.impl;

import com.wzq.mapper.HeatMapper;
import com.wzq.service.HeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wzq
 * @date 2020/10/6
 * @email 158957716@qq.com
 */
@Service
public class HeatServiceImpl implements HeatService {

	@Autowired
	private HeatMapper heatMapper;


	@Override
	public int updateHeat(long id) {
		return heatMapper.updateHeat(id);
	}
}

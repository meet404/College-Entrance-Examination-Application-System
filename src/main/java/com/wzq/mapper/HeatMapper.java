package com.wzq.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzq.pojo.Heat;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author wzq
 * @date 2020/10/6
 * @email 158957716@qq.com
 */
@Repository
public interface HeatMapper{
	@Update("update heat set heats=heats+1 WHERE school_id=#{school_id}")
	int updateHeat(long id);
}

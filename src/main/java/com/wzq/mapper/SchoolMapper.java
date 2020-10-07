package com.wzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzq.pojo.School;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author wzq
 * @date 2020/10/2
 * @email 158957716@qq.com
 */
@Repository
public interface SchoolMapper extends BaseMapper<School> {

	@Select("SELECT count(*) from school WHERE deleted = 0")
	int count();

}

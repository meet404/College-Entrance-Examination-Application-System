package com.wzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzq.pojo.Score;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/5
 * @email 158957716@qq.com
 */
@Repository
public interface ScoreMapper extends BaseMapper<Score> {

	/**
	 * score.school_id根据学校查询相关分数线，并按年份降序排序
	 *
	 * @param id
	 * @return
	 */
	@Select("SELECT\n" +
			"\tse.*,\n" +
			"\tsl.school_name \n" +
			"FROM\n" +
			"\tscore AS se,\n" +
			"\tschool AS sl \n" +
			"WHERE\n" +
			"\tse.school_id = sl.id \n" +
			"\tAND se.school_id = #{school_id} \n" +
			"ORDER BY\n" +
			"\tse.YEAR DESC")
	List<Score> findAllBySchoolId(long id);
}

package com.wzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzq.pojo.Major;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @date 2020/10/4
 * @email 158957716@qq.com
 */
@Repository
public interface MajorMapper extends BaseMapper<Major> {

	@Select("select m.*,s.school_name from major as m,school as s where m.school_id=s.id")
	List<Major> findAll();

}

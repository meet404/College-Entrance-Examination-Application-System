package com.wzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzq.pojo.Major;
import com.wzq.pojo.School;
import org.apache.ibatis.annotations.Param;
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

	@Select("SELECT\n" +
			"\tm.*,\n" +
			"\ts.school_name \n" +
			"FROM\n" +
			"\tmajor AS m,\n" +
			"\tschool AS s \n" +
			"WHERE\n" +
			"\tm.school_id = s.id")
	List<Major> findAll();

	@Select("SELECT\n" +
			"\tm.*,\n" +
			"\ts.school_name \n" +
			"FROM\n" +
			"\tschool AS s,\n" +
			"\tmajor AS m \n" +
			"WHERE\n" +
			"\tm.school_id = s.id \n" +
			"\tAND s.school_name LIKE concat(\n" +
			"\t'%',#{name},'%')")
	List<Major> findAllByName(String name);

	@Select("SELECT count(*) from major")
	int count();

}

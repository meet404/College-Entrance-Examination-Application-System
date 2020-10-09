package com.wzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzq.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

	@Select("SELECT\n" +
			"\tp.CODE \n" +
			"FROM\n" +
			"\tUSER AS u,\n" +
			"\trole AS r,\n" +
			"\trole_perm AS rp,\n" +
			"\tpermission AS p \n" +
			"WHERE\n" +
			"\tu.role_id = r.id \n" +
			"\tAND r.id = rp.role_id \n" +
			"\tAND rp.permission_id = p.id \n" +
			"\tAND u.username = #{username}")
	Set<String> findPermissionsByUsername(String username);


	@Select("SELECT\n" +
			"\tr.code \n" +
			"FROM\n" +
			"\tUSER AS u,\n" +
			"\trole AS r\n" +
			"WHERE\n" +
			"\tu.role_id = r.id \n" +
			"\tAND u.username = #{username}")
	Set<String> findRolesByUsername(String username);

}

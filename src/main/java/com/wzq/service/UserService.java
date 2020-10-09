package com.wzq.service;

import com.wzq.pojo.User;

import java.util.Set;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
public interface UserService {
	/**
	 * 注册用户
	 *
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * 登陆认证
	 *
	 * @param username
	 * @return
	 */
	User querryUserLogin(String username);

	/**
	 * 查找角色
	 *
	 * @param username
	 * @return
	 */
	Set<String> findRolesByUsername(String username);

	/**
	 * 查找权限
	 *
	 * @param username
	 * @return
	 */
	Set<String> findPermissionsByUsername(String username);


}

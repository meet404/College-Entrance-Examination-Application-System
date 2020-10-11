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
	 * 登陆判断
	 *
	 * @param username
	 * @return
	 */
	User loginUserByName(String username);

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

	/**
	 * 激活用户
	 *
	 * @param user
	 * @return
	 */
	int activeUser(User user);

	/**
	 * 根据id查找用户
	 *
	 * @param id
	 * @return
	 */
	User findUserById(long id);

	/**
	 * 通过邮箱查找
	 *
	 * @param email
	 * @return
	 */
	User findUserByEmail(String email);

	/**
	 * 通过用户名查找
	 *
	 * @param name
	 * @return
	 */
	User findUserByName(String username);

}

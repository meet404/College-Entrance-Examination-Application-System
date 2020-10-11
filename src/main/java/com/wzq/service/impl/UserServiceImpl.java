package com.wzq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzq.mapper.UserMapper;
import com.wzq.pojo.User;
import com.wzq.service.UserService;
import com.wzq.utils.GetSaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		String password = user.getPassword();
		String salt = GetSaltUtil.getSalt();
		user.setPrivateSalt(salt);
		Md5Hash md5Hash = new Md5Hash(password, salt, 1); //md5加密一次
		user.setPassword(md5Hash.toString());
		user.setUserStatus(2);
		return userMapper.insert(user);
	}

	@Override
	public User loginUserByName(String username) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", username).eq("user_status", 0);
		User user = userMapper.selectOne(wrapper);
		return user;
	}

	@Override
	public Set<String> findRolesByUsername(String username) {
		return userMapper.findRolesByUsername(username);
	}

	@Override
	public Set<String> findPermissionsByUsername(String username) {
		return userMapper.findPermissionsByUsername(username);
	}

	@Override
	public int activeUser(User user) {
		return userMapper.updateById(user);
	}

	@Override
	public User findUserById(long id) {
		return userMapper.selectById(id);
	}

	@Override
	public User findUserByEmail(String email) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("email", email);
		User user = userMapper.selectOne(wrapper);
		return user;
	}

	@Override
	public User findUserByName(String username) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", username);
		User user = userMapper.selectOne(wrapper);
		return user;
	}

}

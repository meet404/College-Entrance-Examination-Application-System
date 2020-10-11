package com.wzq.config;

import com.wzq.pojo.User;
import com.wzq.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("执行授权==>doGetAuthorizationInfo");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		//拿到登陆对象
		Subject subject = SecurityUtils.getSubject();
		User principal = (User) subject.getPrincipal();//拿到user对象
		String username = principal.getUsername();
		System.out.println(username);
		//设置当前用户权限
		//从数据库查询权限和角色
		Set<String> roles = userService.findRolesByUsername(username);
		if (roles != null && roles.size() > 0) {
			info.addRoles(roles);
		}

		Set<String> permissions = userService.findPermissionsByUsername(username);
		if (permissions != null && roles.size() > 0) {
			info.addStringPermissions(permissions);
		}
		System.out.println("鉴权完毕，准备返回~" + "roles=" + roles + "permissions=" + permissions);
		System.out.println("---info---------->>>"+info);
		return info;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证==>doGetAuthenticationInfo");

		UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		//数据库拿密码
		User user = userService.loginUserByName(userToken.getUsername());
		if (user == null) {
			return null;
		}
		Subject currentSubject = SecurityUtils.getSubject();
		Session session = currentSubject.getSession();
		session.setAttribute("user", user);
		//密码认证，shiro做
		SimpleByteSource salt = new SimpleByteSource(user.getPrivateSalt());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),salt,getName());
		return authenticationInfo;
	}

}

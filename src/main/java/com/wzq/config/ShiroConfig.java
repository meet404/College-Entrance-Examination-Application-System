package com.wzq.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wzq
 * @date 2020/10/9
 * @email 158957716@qq.com
 */
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		//设置安全管理器
		bean.setSecurityManager(defaultWebSecurityManager);
		/**
		 * 添加过滤器
		 * anon:无需认证可以访问
		 * authc:必须认证才能访问
		 * user:必须有记住我才能访问
		 * perms:拥有某个资源权限才能访问
		 * role:拥有某个角色权限才能访问
		 */
		Map<String, String> filterMap = new LinkedHashMap<>();

		/**
		 * 无需认证
		 */
		filterMap.put("/", "anon");
		filterMap.put("/login/toLogin", "anon");
		filterMap.put("/user/toRegister", "anon");
		filterMap.put("/active/*", "anon");

		/**
		 * 需要授权
		 */
		filterMap.put("/page/searchSchoolPage/*", "perms[user:page:searchSchoolPage]");
		filterMap.put("/page/searchMajor", "perms[user:page:searchMajor]");
		filterMap.put("/school/schoolList/*", "perms[admin:school:schoolList]");
		filterMap.put("/school/add", "perms[admin:school:add]");
		filterMap.put("/school/delete/*", "perms[admin:school:delete]");
		filterMap.put("/school/update", "perms[admin:school:update]");
		filterMap.put("/school/findByName", "perms[admin:school:findByName]");
		filterMap.put("/major/add", "perms[admin:major:add]");
		filterMap.put("/major/delete/*", "perms[admin:major:delete]");
		filterMap.put("/major/update", "perms[admin:major:update]");
		filterMap.put("/major/findAll", "perms[admin:major:findAll]");
		filterMap.put("admin:major:findByName", "perms[/major/findByName]");

		/**
		 * 需要角色
		 */
		filterMap.put("/admin/*", "roles[super_admin]");

		bean.setFilterChainDefinitionMap(filterMap);

		//设置登陆请求
		bean.setLoginUrl("/login/toLogin");
		//未授权
		bean.setUnauthorizedUrl("/common/noauth");
		//登出
		filterMap.put("/login/logout", "logout");
		return bean;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	/**
	 * 创建realm对象
	 * @return
	 */
	@Bean
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		//告诉realm密码匹配方式
		userRealm.setCredentialsMatcher(credentialsMatcher());
		return userRealm;
	}

	@Bean
	public CredentialsMatcher credentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		//加密方式
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		//加密次数
		hashedCredentialsMatcher.setHashIterations(1);
		return hashedCredentialsMatcher;
	}

	//整合shiro和thymelesf
	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

}

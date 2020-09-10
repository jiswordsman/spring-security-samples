/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Joe Grandja
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("customUserDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// 配置要控制的http URL
				.authorizeRequests()
					// 对于静态文件和页面不拦截。
					.antMatchers("/css/**", "/index").permitAll()
					// /user/下的请求只有拥有USER角色的用户才能访问
					.antMatchers("/user/**").hasRole("USER")
					// USER角色的用户可以访问/user/api/下的资源
					.antMatchers("/user/api/**").hasRole("USER")
					// ADMIN角色的用户可以访问/admin/api/下的资源
					.antMatchers("/admin/api/**").hasRole("ADMIN")
					// /app/api/下的资源不做控制
					.antMatchers("/app/api/**").permitAll()
				// 回到HttpSecurity
				.and()
				// 设置通过表单进行登录认证
				.formLogin()
					// 登录页名称（即login.html)，登录页不需要权限控制
					.loginPage("/login")
					// 登录校验地址，点击登录按钮时会跳转到该地址
					.loginProcessingUrl("/loginUrl")
					// 登录错误页地址
					.failureUrl("/login-error")
				.and()
					// 添加验证码校验过滤器
					.addFilterBefore(new CaptchaFilter(), UsernamePasswordAuthenticationFilter.class)
				.rememberMe();
	}

	/*@Override
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder()
				// 用户名
				.username("admin")
				// 密码
				.password("password")
				// 拥有的角色
				.roles("ADMIN", "USER")
				.build();
		UserDetails user = User.withDefaultPasswordEncoder()
				// 用户名
				.username("user")
				// 密码
				.password("password")
				// 拥有的角色
				.roles("USER")
				.build();
		// 构建一个存储在内存中的用户信息
		return new InMemoryUserDetailsManager(admin, user);
	}*/

	/*@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		if (!manager.userExists("admin")) {
			manager.createUser(User.withUsername("admin").password("{noop}password").roles("ADMIN", "USER").build());
		}
		if (!manager.userExists("user")) {
			manager.createUser(User.withUsername("user").password("{noop}password").roles("USER").build());
		}
		return manager;
	}*/
}

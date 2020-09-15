/*
 * Copyright 2002-2016 the original author or authors.
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
package org.springframework.samples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joe Grandja
 */
@Controller
public class MainController {

	@RequestMapping("/")
	public String root() {
		// 重定向到/index
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index() {
		// 返回index.html页面
		return "index";
	}

	@RequestMapping("/user/index")
	public String userIndex() {
		// 返回/user/index.html页面
		return "user/index";
	}

	@RequestMapping("/login")
	public String login() {
		// 跳转到登录页(login.html)
		return "login";
	}

	@RequestMapping("/createUserPage")
	public String createUserPage() {
		return "user/create";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model, String msg) {
		if (msg == null) {
			msg = "用户名或密码错误";
		}
		model.addAttribute("loginErrorMsg", msg);
		// 跳转到登录页
		return "login";
	}

}

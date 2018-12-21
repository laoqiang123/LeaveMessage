package com.example.test.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.test.domain.User;
import com.example.test.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	private UserService us;

	public UserService getUs() {
		return us;
	}

	@Resource(name = "us")
	public void setUs(UserService us) {
		this.us = us;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h1")
	public String initLogin(ModelMap model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h2")
	public String forgetPass(ModelMap model) {
		model.addAttribute("user", new User());
		return "forget";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h3")
	public String login(@Valid @ModelAttribute("user") User user, Errors error, HttpSession session)
			throws SQLException {
		// 验证用户的信息，根据权限进入相应的界面
		if (error.hasFieldErrors("name") || error.hasFieldErrors("pass")) {
			return "login";
		}
		com.example.test.javabean.User u = new com.example.test.javabean.User();
		u.setUserName(user.getName());
		u.setUserPass(user.getPass());
		com.example.test.javabean.User u1 = us.login(u);
		if (u1 == null) {
			System.out.println("user login error");
			return "login";
		} else {
			// 将用户的登录信息存放到session 中
			session.setAttribute("user", u1);
			return "redirect:/board/h4";

		}
	}

}

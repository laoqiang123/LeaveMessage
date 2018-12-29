package com.example.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.test.domain.User;
import com.example.test.service.UserService;
import com.example.test.util.ValidationCodeUtil;

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

	@RequestMapping(method = RequestMethod.GET, value = "/h4")
	public void getVerification(HttpServletResponse response, HttpSession session) throws IOException {
		ValidationCodeUtil vCode = new ValidationCodeUtil(120, 35, 5, 50);
		response.setContentType("image/jpeg");
		vCode.write(response.getOutputStream());
		// 将验证码的值存入到session 中
		session.setAttribute("loginverificationcode", vCode.getCode());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h2")
	public String forgetPass(ModelMap model) {
		model.addAttribute("user", new User());
		return "forget";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h3")
	public ModelAndView login(@Valid @ModelAttribute("user") User user, Errors error, HttpSession session)
			throws SQLException {
		ModelAndView mav = new ModelAndView();
		// 验证用户的信息，根据权限进入相应的界面
		if (error.hasFieldErrors("name") || error.hasFieldErrors("pass") || error.hasFieldErrors("verification")) {
			mav.setViewName("login");
			return mav;
		}
		if (!session.getAttribute("loginverificationcode").equals(user.getVerification())) {
			mav.setViewName("login");
			mav.addObject("loginverificationerrormessage", "login verification is error");
			return mav;
		}
		com.example.test.javabean.User u = new com.example.test.javabean.User();
		u.setUserName(user.getName());
		u.setUserPass(user.getPass());
		com.example.test.javabean.User u1 = us.login(u);
		if (u1 == null) {
			mav.setViewName("login");
			mav.addObject("loginerror", "user not exist or not active!");
			return mav;
		} else {
			// 管理员进入管理界面
			if (user.getName().equals("root") && user.getPass().equals("rootroot")) {
				mav.setViewName("redirect:/manage/h1");
				return mav;
			}
			// 将用户的登录信息存放到session 中
			session.setAttribute("user", u1);
			mav.setViewName("redirect:/board/h4");
			return mav;

		}
	}

}

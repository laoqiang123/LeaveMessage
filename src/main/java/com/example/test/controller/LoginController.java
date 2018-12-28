package com.example.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String initLogin(ModelMap model) throws IOException {
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping(method=RequestMethod.GET,value="/h4")
	public String getVerification() {
		return "verification";
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/h2")
	public String forgetPass(ModelMap model) {
		model.addAttribute("user", new User());
		return "forget";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h3")
	public String login(@Valid @ModelAttribute("user") User user, Errors error, HttpSession session)
			throws SQLException {
		// ��֤�û�����Ϣ������Ȩ�޽�����Ӧ�Ľ���
		if (error.hasFieldErrors("name") || error.hasFieldErrors("pass")||error.hasFieldErrors("verification")) {
			return "login";
		}if(!session.getAttribute("verification").equals(user.getVerification())) {
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
			// ����Ա����������
			if (user.getName().equals("root") && user.getPass().equals("rootroot")) {
				return "redirect:/manage/h1";
			}
			// ���û��ĵ�¼��Ϣ��ŵ�session ��
			session.setAttribute("user", u1);
			return "redirect:/board/h4";

		}
	}

}

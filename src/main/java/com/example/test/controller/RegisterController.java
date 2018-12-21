package com.example.test.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
import com.example.test.util.EmailUtil;

/**
 * 
 * @author laoqiang
 * 
 *
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	private UserService us;

	public UserService getUs() {
		return us;
	}

	@Resource(name = "us")
	public void setUs(UserService us) {
		this.us = us;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h1")
	public String getInitRigisterForm(ModelMap model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h2")
	public String register(@Valid @ModelAttribute("user") User user, Errors error, HttpSession session)
			throws AddressException, MessagingException, SQLException {
		if (error.hasFieldErrors("name") || error.hasFieldErrors("pass") || error.hasFieldErrors("email")) {
			return "register";
		}
		// 进行数据库插入操作，注意数据库字段active 0 未激活
		// 发送邮件
		com.example.test.javabean.User u = new com.example.test.javabean.User();
		u.setUserName(user.getName());
		u.setUserPass(user.getPass());
		u.setEmail(user.getEmail());
		int row = us.register(u);
		if (row > 0) {
			com.example.test.javabean.User u1 = us.selectUserByEmail(u);
			String from = "postmaster@localhost";
			String uuid = UUID.randomUUID().toString();
			session.setAttribute("uuid", uuid);
			session.setAttribute("userId", u1.getUserId());
			session.setAttribute("activedate", new Date());
			session.setAttribute("activedcount", null);
			EmailUtil.sendEmail(user.getEmail(), from, "the active link of LeaveMessage System",
					"Hello,man or woman,please "
							+ "click the link to active http://localhost:9999/LeaveMessageSystem/active/h1?uuid=" + uuid
							+ "within three mintues");
			return "active";
		} else {
			return "register";
		}
	}

}

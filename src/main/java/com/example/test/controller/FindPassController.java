package com.example.test.controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
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
import com.example.test.util.EmailUtil;
import com.example.test.util.RandNumberUtil;

/**
 * 
 * @author laoqiang
 *
 */
@Controller
@RequestMapping(value = "findpass")
public class FindPassController {
	private UserService us;

	public UserService getUs() {
		return us;
	}

	@Resource(name = "us")
	public void setUs(UserService us) {
		this.us = us;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h3")
	public ModelAndView checkUserInfo(@ModelAttribute("user") User user, HttpSession session, ModelMap model)
			throws SQLException {
		// 如果验证码正常，通过邮箱
		ModelAndView mav = new ModelAndView();
		Date currentDate = new Date();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime((Date) session.getAttribute("startverification"));
		com.example.test.javabean.User u = new com.example.test.javabean.User();
		u.setEmail(user.getEmail());
		com.example.test.javabean.User u1 = us.selectUserByEmail(u);
		if (u1 != null && Math.abs(c1.get(Calendar.MINUTE) - c2.get(Calendar.MINUTE)) < 3
				&& session.getAttribute("verification").equals(user.getVerification())) {
			model.addAttribute("user", new User());
			session.setAttribute("oldpass", u1.getUserPass());
			session.setAttribute("userid", u1.getUserId());
			mav.setViewName("updatepass");
			return mav;
		}
		mav.addObject("forgeterror", "please check your information again!");
		mav.setViewName("forget");
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/h1")
	public void getVerification(@ModelAttribute("user") User user, ModelMap model, HttpServletRequest request,
			HttpSession session) throws AddressException, MessagingException {
		String email = request.getParameter("email");
		String to = email;
		String from = "postmaster@localhost";
		String subject = "the verification of find pass";
		String verification = RandNumberUtil.generateNumber();
		session.setAttribute("verification", verification);
		session.setAttribute("startverification", new Date());
		String message = "please input the verification:" + verification
				+ ",within three mintues,If you do not do it yourself, ignore it";
		EmailUtil.sendEmail(to, from, subject, message);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h2")
	public ModelAndView resetPass(@Valid @ModelAttribute("user") User user, Errors error, ModelMap model,
			HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView();
		if (error.hasFieldErrors("pass") || error.hasFieldErrors("newpass")) {
			mav.setViewName("updatepass");
			return mav;
		}
		// 只有新老密码一致，才会执行后面的数据库操作
		if (session.getAttribute("oldpass").equals(user.getPass())
				&& updatePass(user, (Integer) session.getAttribute("userid"))) {
			model.addAttribute("user", new User());
			mav.setViewName("redirect:/login/h1");
			return mav;
		} else {
			mav.addObject("updatepasserror", "please check your old and new pass is equal!");
			mav.setViewName("updatepass");
			return mav;
		}

	}

	public boolean updatePass(User user, int id) throws SQLException {
		com.example.test.javabean.User u = new com.example.test.javabean.User();
		u.setUserPass(user.getNewpass());
		u.setUserId(id);
		int row = us.updatePass(u);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}
}

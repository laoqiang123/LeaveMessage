package com.example.test.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.test.javabean.User;
import com.example.test.service.BoardService;
import com.example.test.service.ReplyService;
import com.example.test.service.UserService;

/**
 * 
 * @author laoqiang
 *
 */
@Controller
@RequestMapping(value = "/manage")
public class ManageController {
	private UserService us;
	private BoardService bs;
	private ReplyService rs;

	public UserService getUs() {
		return us;
	}

	@Resource(name = "us")
	public void setUs(UserService us) {
		this.us = us;
	}

	public BoardService getBs() {
		return bs;
	}

	@Resource(name = "bs")
	public void setBs(BoardService bs) {
		this.bs = bs;
	}

	public ReplyService getRs() {
		return rs;
	}

	@Resource(name = "rs")
	public void setRs(ReplyService rs) {
		this.rs = rs;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h1")
	public ModelAndView getUserList() throws SQLException {
		ModelAndView mav = new ModelAndView();
		List<User> list = us.selectAllUser();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				User user = new User();
				user.setUserId(list.get(i).getUserId());
				int boardCount = bs.selectBoardCountByUserId(user);
				int replyCount = rs.selectReplyCountByUserId(user);
				list.get(i).setReplyCount(replyCount);
				list.get(i).setBoardCount(boardCount);
			}
			mav.setViewName("root");
			mav.addObject("list", list);
			return mav;
		} else {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h2")
	public String deleteUserByUserId(HttpServletRequest request) throws SQLException {
		User user = new User();
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		int row = us.deleteUserByuserId(user);
		if (row > 0) {
			return "redirect:/manage/h1";
		} else {
			return null;
		}
	}
}

package com.example.test.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.test.domain.Board;
import com.example.test.javabean.User;
import com.example.test.service.BoardService;

/**
 * 
 * @author laoqiang
 *
 */
@Controller
@RequestMapping(value = "board")
public class BoradController {
	private BoardService bs;

	public BoardService getBs() {
		return bs;
	}

	@Resource(name = "bs")
	public void setBs(BoardService bs) {
		this.bs = bs;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h1")
	public String initpublishBoard(ModelMap model) {
		model.addAttribute("board", new Board());
		return "publishboard";
	}

	/**
	 * 
	 * @param board
	 * @param error
	 * @return use to publish board
	 * @throws SQLException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/h2")
	public String handerPublish(@Valid @ModelAttribute("board") Board board, Errors error, HttpSession session)
			throws SQLException {
		if (error.hasFieldErrors("boardName") || error.hasFieldErrors("content")) {
			return "publishboard";
		}
		com.example.test.javabean.Board b = new com.example.test.javabean.Board();
		b.setBoardName(board.getBoardName());
		b.setBoardContent(board.getContent());
		User u = new User();
		u.setUserId(((User) session.getAttribute("user")).getUserId());
		b.setUser(u);
		int row = bs.publish(b);
		if (row > 0) {
			return "show";
		} else {
			return "publishboard";
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/h4")
	public ModelAndView loadAllBoard() throws SQLException {
		ModelAndView mav = new ModelAndView();
		List<com.example.test.javabean.Board> list = bs.selectAllBoard();
		System.out.println(list.size()+"jjjj");
		mav.addObject("boards", list);
		mav.setViewName("show");
		return mav;
	}

}

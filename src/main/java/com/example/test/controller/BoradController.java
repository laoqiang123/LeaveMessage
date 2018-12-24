package com.example.test.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
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

import com.example.test.domain.Board;
import com.example.test.javabean.Reply;
import com.example.test.javabean.User;
import com.example.test.service.BoardService;
import com.example.test.service.ReplyService;

/**
 * 
 * @author laoqiang
 *
 */
@Controller
@RequestMapping(value = "board")
public class BoradController {
	private BoardService bs;
	private ReplyService rs;

	public BoardService getBs() {
		return bs;
	}

	public ReplyService getRs() {
		return rs;
	}

	@Resource(name = "rs")
	public void setRs(ReplyService rs) {
		this.rs = rs;
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
			return "redirect:/board/h4";
		} else {
			return "publishboard";
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/h4")
	public ModelAndView loadAllBoard(HttpServletRequest request, ModelMap model) throws SQLException {
		ModelAndView mav = new ModelAndView();
		int boardcount = bs.selectBoardCount();
		int pagecount = 0;
		if (boardcount % 3 == 0) {
			pagecount = boardcount / 3;
			pagecount -= 1;
		} else {
			pagecount = boardcount / 3;
		}
		model.addAttribute("max", pagecount);
		if (request.getParameter("page") != null) {
			int page = Integer.parseInt(request.getParameter("page"));
			model.addAttribute("p", page);
			List<com.example.test.javabean.Board> list = selectBoardByPage(page);
			mav.addObject("boards", list);
			mav.setViewName("show");
			return mav;
		} else {
			model.addAttribute("p", 0);
			List<com.example.test.javabean.Board> list = selectBoardByPage(0);
			mav.addObject("boards", list);
			mav.setViewName("show");
			return mav;
		}
	}

	public List<com.example.test.javabean.Board> selectBoardByPage(int page) throws SQLException {
		List<com.example.test.javabean.Board> list = bs.selectAllBoard(page);
		for (int i = 0; i < list.size(); i++) {
			List<Reply> listReply = rs.selectPublishDateByBoardId(list.get(i));
			if (listReply != null) {
				list.get(i).setRecentReplyDate(listReply.get(0).getPublishDate());
				list.get(i).setReplyCount(listReply.size());
			}
		}
		return list;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h3")
	public String forwardBoard(HttpServletRequest request, HttpSession session) throws SQLException {
		com.example.test.javabean.Board board = new com.example.test.javabean.Board();
		board.setBoardId(Integer.parseInt(request.getParameter("boardId")));
		int row = bs.insertBoardByForward(board, ((User) session.getAttribute("user")).getUserId());
		if (row > 0) {
			return "redirect:/board/h4";
		} else {
			System.out.println("forward fail!");
			return null;
		}
	}
}

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

import com.example.test.domain.Reply;
import com.example.test.javabean.Board;
import com.example.test.service.BoardService;
import com.example.test.service.ReplyService;

/**
 * 
 * @author laoqiang
 *
 */
@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
	private BoardService bs;
	private ReplyService rs;

	public ReplyService getRs() {
		return rs;
	}

	@Resource(name = "rs")
	public void setRs(ReplyService rs) {
		this.rs = rs;
	}

	public BoardService getBs() {
		return bs;
	}

	@Resource(name = "bs")
	public void setBs(BoardService bs) {
		this.bs = bs;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h1")
	public ModelAndView initReply(ModelMap model, HttpServletRequest request, HttpSession session) throws SQLException {
		model.addAttribute("reply", new Reply());
		String boardId = null;
		if (request.getParameter("boardId") == null) {
			boardId = String.valueOf(session.getAttribute("boardId"));
		} else {
			boardId = request.getParameter("boardId");
			session.setAttribute("boardId", boardId);
		}
		Board board = new Board();
		board.setBoardId(Integer.parseInt(boardId));
		int boardcount = rs.selectReplyCountByBoardId(board);
		int pagecount = 0;
		if (boardcount % 3 == 0) {
			pagecount = boardcount / 3;
			pagecount -= 1;
		} else {
			pagecount = boardcount / 3;
		}
		model.addAttribute("max", pagecount);
		session.setAttribute("boardId", Integer.parseInt(boardId));
		Board b = bs.selectBoardByBoardId(board);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", b);
		if (request.getParameter("page") != null) {
			int page = Integer.parseInt(request.getParameter("page"));
			model.addAttribute("p", page);
			List<com.example.test.javabean.Reply> list = rs.selectReplyByBoardId(board, page);
			mav.setViewName("reply");
			mav.addObject("replys", list);
			return mav;
		} else {
			model.addAttribute("p", 0);
			List<com.example.test.javabean.Reply> list = rs.selectReplyByBoardId(board, 0);
			mav.addObject("boards", list);
			mav.addObject("replys", list);
			mav.setViewName("reply");
			return mav;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h2")
	public String addReply(ModelMap model) {
		model.addAttribute("reply", new Reply());
		return "addreply";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h3")
	public String submitReply(ModelMap model, HttpSession session, @Valid @ModelAttribute("reply") Reply reply,
			Errors error) throws SQLException {
		if (error.hasFieldErrors("replyContent")) {
			return "addreply";
		}
		model.addAttribute("reply", new Reply());
		Board b = new Board();
		com.example.test.javabean.Reply r = new com.example.test.javabean.Reply();
		r.setReplyContent(reply.getReplyContent());
		b.setBoardId(Integer.parseInt(String.valueOf(session.getAttribute("boardId"))));
		int row = rs.insertReplyByBoardId(r, b);
		if (row > 0) {
			return "redirect:/reply/h1?boardId=" + session.getAttribute("boardId");
		} else {
			return "addreply";

		}

	}

}

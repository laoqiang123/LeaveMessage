package com.example.test.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.example.test.daoimpl.ReplyDaoImpl;
import com.example.test.javabean.Board;
import com.example.test.javabean.Reply;
import com.example.test.javabean.User;

/**
 * 
 * @author laoqiang
 *
 */
public class ReplyService {
	private ReplyDaoImpl rdi;

	public ReplyDaoImpl getRdi() {
		return rdi;
	}

	@Resource(name = "rdi")
	public void setRdi(ReplyDaoImpl rdi) {
		this.rdi = rdi;
	}

	/**
	 * 根据某一个boardid去插入一个reply
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int insertReplyByBoardId(Reply reply, Board board) throws SQLException {
		return rdi.insertReplyByPublish(reply, board);
	}

	/**
	 * 根据boardid 去查询最近回复的时间
	 * @param board
	 * @return
	 * @throws SQLException
	 */
	public List<Reply> selectPublishDateByBoardId(Board board) throws SQLException {
		return rdi.selectReplyRecetPublishDateAndCountByBoardId(board);
	}
	/**
	 * 根据boardId 去查询reply,分页去查询
	 * @return
	 * @throws SQLException 
	 */
	public List<Reply> selectReplyByBoardId(Board board,int page) throws SQLException{
		List<Reply> list = rdi.selectReplyByBoardId(board,page);
		return list;
	}
	/**
	 * 查询某个一个用户的回复数
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int selectReplyCountByUserId(User user) throws SQLException {
		return rdi.selectReplyCountByUserId(user);
	}
	/**
	 * 查询BoardId 下的回复数
	 * @param board
	 * @return
	 * @throws SQLException
	 */
	public int selectReplyCountByBoardId(Board board) throws SQLException{
		return rdi.selectReplyCountByBoardId(board);
	}
}

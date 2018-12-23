package com.example.test.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.example.test.daoimpl.ReplyDaoImpl;
import com.example.test.javabean.Board;
import com.example.test.javabean.Reply;

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
	 * ����ĳһ��boardidȥ����һ��reply
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int insertReplyByBoardId(Reply reply, Board board) throws SQLException {
		return rdi.insertReplyByPublish(reply, board);
	}

	/**
	 * ����boardid ȥ��ѯ����ظ���ʱ��
	 * @param board
	 * @return
	 * @throws SQLException
	 */
	public List<Reply> selectPublishDateByBoardId(Board board) throws SQLException {
		return rdi.selectReplyRecetPublishDateAndCountByBoardId(board);
	}
	/**
	 *  ����boardId ȥ��ѯreply
	 * @return
	 * @throws SQLException 
	 */
	public List<Reply> selectReplyByBoardId(Board board) throws SQLException{
		List<Reply> list = rdi.selectReplyByBoardId(board);
		return list;
	}
}

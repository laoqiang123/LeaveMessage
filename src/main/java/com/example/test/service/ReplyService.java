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
	 * ����boardId ȥ��ѯreply,��ҳȥ��ѯ
	 * @return
	 * @throws SQLException 
	 */
	public List<Reply> selectReplyByBoardId(Board board,int page) throws SQLException{
		List<Reply> list = rdi.selectReplyByBoardId(board,page);
		return list;
	}
	/**
	 * ��ѯĳ��һ���û��Ļظ���
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int selectReplyCountByUserId(User user) throws SQLException {
		return rdi.selectReplyCountByUserId(user);
	}
	/**
	 * ��ѯBoardId �µĻظ���
	 * @param board
	 * @return
	 * @throws SQLException
	 */
	public int selectReplyCountByBoardId(Board board) throws SQLException{
		return rdi.selectReplyCountByBoardId(board);
	}
}

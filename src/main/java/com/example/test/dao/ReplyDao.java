package com.example.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.test.javabean.Board;
import com.example.test.javabean.Reply;

/**
 * 
 * @author laoqiang
 *
 */
public interface ReplyDao {
	List<Reply> selectReplyByBoardId(Board board) throws SQLException;

	int insertReplyByPublish(Reply reply, Board board) throws SQLException;

	List<Reply> selectReplyRecetPublishDateAndCountByBoardId(Board board) throws SQLException;
}

package com.example.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.test.javabean.Board;
import com.example.test.javabean.Reply;
import com.example.test.javabean.User;

/**
 * 
 * @author laoqiang
 *
 */
public interface ReplyDao {

	int insertReplyByPublish(Reply reply, Board board) throws SQLException;

	List<Reply> selectReplyRecetPublishDateAndCountByBoardId(Board board) throws SQLException;

	int selectReplyCountByUserId(User user) throws SQLException;

	int selectReplyCountByBoardId(Board board) throws SQLException;

	List<Reply> selectReplyByBoardId(Board board, int page) throws SQLException;
}

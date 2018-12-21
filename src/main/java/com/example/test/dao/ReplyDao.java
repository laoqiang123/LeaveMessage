package com.example.test.dao;

import java.sql.SQLException;

import com.example.test.javabean.Board;
import com.example.test.javabean.Reply;

/**
 * 
 * @author laoqiang
 *
 */
public interface ReplyDao {
	Reply selectReply(Board board) throws SQLException;

	int selectReplyCount(Board board) throws SQLException;

	int insertReplyByPublish(Reply reply) throws SQLException;
}

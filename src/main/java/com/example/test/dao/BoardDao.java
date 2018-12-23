package com.example.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.test.javabean.Board;
import com.example.test.javabean.User;


/**
 * 
 * @author laoqiang
 *
 */
public interface BoardDao {
	List<Board> selectAllBoard() throws SQLException;
	int selectBoardCountByUserId(User user) throws SQLException;
	int addBoardByPublish(Board board) throws SQLException;
	Board selectBoardByBoardId(Board board) throws SQLException;
}

package com.example.test.service;
/**
 * 
 * @author laoqiang
 *
 */

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.example.test.daoimpl.BoardDaoImpl;
import com.example.test.javabean.Board;

public class BoardService {
	private BoardDaoImpl bdi;

	public BoardDaoImpl getBdi() {
		return bdi;
	}

	@Resource(name = "bdi")
	public void setBdi(BoardDaoImpl bdi) {
		this.bdi = bdi;
	}

	/**
	 * 发布一条Board 信息
	 * 
	 * @param board
	 * @return
	 * @throws SQLException
	 */
	public int publish(Board board) throws SQLException {
		int row = bdi.addBoardByPublish(board);
		return row;
	}
    /**
     * 根据页数显示所有board
     * @return
     * @throws SQLException
     */
	public List<Board> selectAllBoard(int page) throws SQLException {
		return bdi.selectAllBoard(page);

	}
	
	public Board selectBoardByBoardId(Board board) throws SQLException {
		return bdi.selectBoardByBoardId(board);
	}
	/**
	 * 处理用于转发业务
	 * @param board
	 * @return
	 * @throws SQLException
	 */
    public int insertBoardByForward(Board board,int userId) throws SQLException {
    	return bdi.insertBoardByForward(board,userId);
    }
    /**
     * 查询多少board
     * @return
     * @throws SQLException 
     */
    public int selectBoardCount() throws SQLException {
    	return bdi.selectBoardCount();
    }
}

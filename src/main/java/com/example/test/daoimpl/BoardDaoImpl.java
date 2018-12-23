package com.example.test.daoimpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.test.dao.BoardDao;
import com.example.test.javabean.Board;
import com.example.test.javabean.BoardRowMapper;
import com.example.test.javabean.User;

/**
 * 
 * @author laoqiang
 *
 */
public class BoardDaoImpl implements BoardDao {
	private JdbcTemplate temple;

	public JdbcTemplate getTemple() {
		return temple;
	}

	@Resource(name = "jdbcTemplate")
	public void setTemple(JdbcTemplate temple) {
		this.temple = temple;
	}

	/**
	 * 查询某一个用户下的Board 数
	 */
	@Override
	public int selectBoardCountByUserId(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) from user where userId=? order by publishDate desc limit 5";
		temple.update(sql);
		int count = temple.getFetchSize();
		return count;
	}

	/**
	 * 列出所有的Board
	 */
	@Override
	public List<Board> selectAllBoard() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) as count,userName,board.boardId,boardName,board.publishDate from user,board,reply where user.userId=board.userId and board.boardId = reply.boardId";
		List<Board> list = temple.query(sql, new BoardRowMapper());
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	/**
	 * 发布board
	 */
	@Override
	public int addBoardByPublish(Board board) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into board(boardName,boardContent,userId,publishDate) values(?,?,?,?)";
		int row = temple.update(sql, board.getBoardName(), board.getBoardContent(), board.getUser().getUserId(),
				new Date());
		return row;
	}

	@Override
	public Board selectBoardByBoardId(Board board) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from board where boardId=?";
		List<Board> list = temple.query(sql, new BoardRowMapper(),board.getBoardId());
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

}

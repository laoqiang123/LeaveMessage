package com.example.test.daoimpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.test.dao.BoardDao;
import com.example.test.javabean.Board;
import com.example.test.javabean.BoardRowMapper;

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
	 *//*
		 * @Override public int selectBoardCountByUserId(User user) throws SQLException
		 * { // TODO Auto-generated method stub String sql =
		 * "select count(*) from user where userId=? order by publishDate desc limit 5";
		 * temple.update(sql); int count = temple.getFetchSize(); return count; }
		 */
	/**
	 * 根据页数列出所有的Board
	 */
	@Override
	public List<Board> selectAllBoard(int page) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select boardId ,userName,boardName,publishDate from board,user where user.userId  = board.userId limit ?,3";
		List<Board> list = temple.query(sql, new BoardRowMapper(),page);
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
		List<Board> list = temple.query(sql, new BoardRowMapper(), board.getBoardId());
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 某用户转发board sql 是通过查询id去进行获取，进行复制插入
	 */
	@Override
	public int insertBoardByForward(Board board, int userId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into board(boardName,boardContent,publishDate,userId) select boardName,boardContent,?,? from board where boardId =?;";
		int row = temple.update(sql, new Date(), userId, board.getBoardId());
		return row;
	}
	/**
	 * 查询有多少board
	 */
	@Override
	public int selectBoardCount() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select count(*) from board";
		int count = temple.queryForInt(sql);
		return count;
	}

}

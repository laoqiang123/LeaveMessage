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
	 * ��ѯĳһ���û��µ�Board ��
	 *//*
		 * @Override public int selectBoardCountByUserId(User user) throws SQLException
		 * { // TODO Auto-generated method stub String sql =
		 * "select count(*) from user where userId=? order by publishDate desc limit 5";
		 * temple.update(sql); int count = temple.getFetchSize(); return count; }
		 */
	/**
	 * ����ҳ���г����е�Board
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
	 * ����board
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
	 * ĳ�û�ת��board sql ��ͨ����ѯidȥ���л�ȡ�����и��Ʋ���
	 */
	@Override
	public int insertBoardByForward(Board board, int userId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into board(boardName,boardContent,publishDate,userId) select boardName,boardContent,?,? from board where boardId =?;";
		int row = temple.update(sql, new Date(), userId, board.getBoardId());
		return row;
	}
	/**
	 * ��ѯ�ж���board
	 */
	@Override
	public int selectBoardCount() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select count(*) from board";
		int count = temple.queryForInt(sql);
		return count;
	}

}

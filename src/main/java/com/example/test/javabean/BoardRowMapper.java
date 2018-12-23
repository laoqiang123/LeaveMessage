package com.example.test.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.test.util.IsExistColumn;

/**
 * 
 * @author laoqiang
 *
 */
public class BoardRowMapper implements RowMapper<Board> {

	@Override
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Board board = new Board();
		if (IsExistColumn.isExistColumn(rs, "publishDate")) {
			board.setPublishDate(rs.getDate("publishDate"));
		}
		if (IsExistColumn.isExistColumn(rs, "boardId")) {
			board.setBoardId((rs.getInt("boardId")));
		}
		if (IsExistColumn.isExistColumn(rs, "boardName")) {
			board.setBoardName(rs.getString("boardName"));
		}
		if (IsExistColumn.isExistColumn(rs, "boardContent")) {
			board.setBoardContent(rs.getString("boardContent"));
		}
		if (IsExistColumn.isExistColumn(rs, "userName")) {
			User user = new User();
			user.setUserName((rs.getString("userName")));
			board.setUser(user);
		}
		if(IsExistColumn.isExistColumn(rs, "count")) {
			board.setReplyCount(rs.getInt("count"));
		}
		return board;
	}

}

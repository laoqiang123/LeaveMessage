package com.example.test.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.test.util.IsExistColumn;

public class ReplyRowMapper implements RowMapper<Reply> {

	@Override
	public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Reply reply = new Reply();
		if (IsExistColumn.isExistColumn(rs, "publishDate")) {
			reply.setPublishDate(rs.getDate("publishDate"));
		}
		if (IsExistColumn.isExistColumn(rs, "replyId")) {
			reply.setReplyId(rs.getInt("replyId"));
		}
		if (IsExistColumn.isExistColumn(rs, "replyContent")) {
			reply.setReplyContent(rs.getString("replyContent"));
		}
		return reply;
	}

}

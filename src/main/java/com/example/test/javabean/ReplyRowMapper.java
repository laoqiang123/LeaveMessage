package com.example.test.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReplyRowMapper implements RowMapper<Reply> {

	@Override
	public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Reply reply = new Reply();
		reply.setPublishDate(rs.getDate("publishDate"));
		reply.setReplyId(rs.getInt("replyId"));
		reply.setReplyContent(rs.getString("replyContent"));
		return reply;
	}

}

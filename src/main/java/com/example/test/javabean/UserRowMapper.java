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
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		if (IsExistColumn.isExistColumn(rs, "userId")) {
			user.setUserId(rs.getInt("userId"));
		}
		if (IsExistColumn.isExistColumn(rs, "userName")) {
			user.setUserName(rs.getString("userName"));
		}
		if (IsExistColumn.isExistColumn(rs, "active")) {
			user.setActive(rs.getInt("active"));
		}
		if (IsExistColumn.isExistColumn(rs, "email")) {
			user.setEmail(rs.getString("email"));
		}
		if (IsExistColumn.isExistColumn(rs, "userPass")) {
			user.setUserPass(rs.getString("userPass"));
		}
		return user;
	}

}

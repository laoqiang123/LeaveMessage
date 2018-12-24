package com.example.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.test.javabean.User;

/**
 * 
 * @author laoqiang
 *
 */
public interface UserDao {
	int insertUserByRegister(User user) throws SQLException;

	User selectUserByLogin(User user) throws SQLException;

	User selectUserByEmail(User user) throws SQLException;

	int updateUserByOldPass(User user) throws SQLException;

	int deleteUser(User user) throws SQLException;

	int updateUserByActive(User user) throws SQLException;

	List<User> selectAllUser() throws SQLException;
}

package com.example.test.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.test.daoimpl.UserDaoImpl;
import com.example.test.javabean.User;

/**
 * 
 * @author laoqiang
 *
 */
public class UserService {
	private UserDaoImpl udi;

	public UserDaoImpl getUdi() {
		return udi;
	}

	@Resource(name = "udi")
	public void setUdi(UserDaoImpl udi) {
		this.udi = udi;
	}

	public int register(User user) throws SQLException {
		int row = udi.insertUserByRegister(user);
		return row;
	}

	/**
	 * 根据激活的邮箱去查找User 信息
	 * 
	 * @throws SQLException
	 */
	public User selectUserByEmail(User user) throws SQLException {
		return udi.selectUserByEmail(user);
	}

	/**
	 * 激活用户
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int active(User user) throws SQLException {
		int row = udi.updateUserByActive(user);
		return row;
	}

	/**
	 * 
	 * @param user
	 * 
	 *            验证用户登录
	 * @return
	 * @throws SQLException
	 */
	public User login(User user) throws SQLException {
		User u = udi.selectUserByLogin(user);
		return u;
	}

	/**
	 * 用户更换密码
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updatePass(User user) throws SQLException {
		return udi.updateUserByOldPass(user);
	}
	/**
	 * 查询所有的用户
	 * @return
	 * @throws SQLException
	 */
	public List<User> selectAllUser() throws SQLException{
		List<User> list = udi.selectAllUser();
		return list;
	}
	/**
	 * 删除指定的用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int deleteUserByuserId(User user) throws SQLException {
		return udi.deleteUser(user);
	}
}

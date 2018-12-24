package com.example.test.daoimpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.test.dao.UserDao;
import com.example.test.javabean.User;
import com.example.test.javabean.UserRowMapper;

/**
 * 
 * @author laoqiang
 *
 */
public class UserDaoImpl implements UserDao {
	private JdbcTemplate temple;

	public JdbcTemplate getTemple() {
		return temple;
	}

	@Resource(name = "jdbcTemplate")
	public void setTemple(JdbcTemplate temple) {
		this.temple = temple;
	}

	/**
	 * ע��
	 */
	@Override
	public int insertUserByRegister(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into user(userName,userPass,email,active) values(?,?,?,0)";
		int row = temple.update(sql, user.getUserName(), user.getUserPass(), user.getEmail());
		return row;
	}

	/**
	 * ɾ��ĳ���û�
	 */
	@Override
	public int deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from user where userId=?";
		int row = temple.update(sql, user.getUserId());
		return row;
	}

	/**
	 * ��¼
	 */
	@Override
	public User selectUserByLogin(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from user where userName=? and userPass =?";
		List<User> list = temple.query(sql, new UserRowMapper(), user.getUserName(), user.getUserPass());
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * ���������������
	 */
	@Override
	public User selectUserByEmail(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from user where email=?";
		List<User> u = temple.query(sql, new UserRowMapper(), user.getEmail());
		if (u.size() == 0) {
			return null;
		} else {
			return u.get(0);
		}
	}

	/**
	 * ��������
	 */
	@Override
	public int updateUserByOldPass(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update user set userPass=? where userId=?";
		int row = temple.update(sql, user.getUserPass(), user.getUserId());
		return row;
	}

	/**
	 * �����û�ȥ����
	 */
	@Override
	public int updateUserByActive(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update user set active=1 where userId=?";
		int row = temple.update(sql, user.getUserId());
		return row;
	}

	/**
	 * 
	 * ��ѯ���еļ����û�
	 */
	@Override
	public List<User> selectAllUser() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select userId ,userName from user where active  = 1";
		List<User> list = temple.query(sql, new UserRowMapper());
		if (list == null) {
			return null;
		} else {
			return list;
		}
	}

}

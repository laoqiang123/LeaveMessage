package com.example.test.daoimpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.test.dao.ReplyDao;
import com.example.test.javabean.Board;
import com.example.test.javabean.Reply;
import com.example.test.javabean.ReplyRowMapper;
import com.example.test.javabean.User;

/**
 * 
 * @author laoqiang
 *
 */
public class ReplyDaoImpl implements ReplyDao {
	private JdbcTemplate temple;

	public JdbcTemplate getTemple() {
		return temple;
	}

	@Resource(name = "jdbcTemplate")
	public void setTemple(JdbcTemplate temple) {
		this.temple = temple;
	}

	/**
	 * ��ѯĳһ��Board �µ�reply
	 */
	@Override
	public List<Reply> selectReplyByBoardId(Board board, int page) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from reply where boardId =?  limit ?,3";
		List<Reply> list = temple.query(sql, new ReplyRowMapper(), board.getBoardId(), page * 3);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	/**
	 * ����»ظ�
	 */
	@Override
	public int insertReplyByPublish(Reply reply, Board board) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into reply(replyContent,boardId,publishDate) values(?,?,?)";
		int row = temple.update(sql, reply.getReplyContent(), board.getBoardId(), new Date());
		return row;
	}

	/**
	 * ����boardId ȥ��ѯ����Ļظ���ʱ��,��Board �µĻظ���
	 */
	@Override
	public List<Reply> selectReplyRecetPublishDateAndCountByBoardId(Board board) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select publishDate from reply  where boardId =? order by publishDate desc";
		List<Reply> list = temple.query(sql, new ReplyRowMapper(), board.getBoardId());
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public int selectReplyCountByUserId(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) as count from user,board,reply where user.userId = board.userId and board.boardId = reply.boardId and user.userId =?";
		int count = temple.queryForInt(sql, user.getUserId());
		return count;
	}
    /**
     * ��ѯĳһ��boardId �Ļظ���
     */
	@Override
	public int selectReplyCountByBoardId(Board board) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select count(*) from reply where boardId=?";
		int count = temple.queryForInt(sql,board.getBoardId());
		return count;
	}

}

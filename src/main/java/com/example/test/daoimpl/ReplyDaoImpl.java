package com.example.test.daoimpl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.test.dao.ReplyDao;
import com.example.test.javabean.Board;
import com.example.test.javabean.Reply;
import com.example.test.javabean.ReplyRowMapper;

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
	public Reply selectReply(Board board) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from reply where boardId =? order by publishDate desc limit 5";
        Reply reply =temple.queryForObject(sql, new ReplyRowMapper(),board.getBoardId()); 
		return reply;
	}
    /**
     * ��ѯĳ���û��µĻظ���
     */
	@Override
	public int selectReplyCount(Board board) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select count(*) from user,reply,board where user.userId=board.userId and board.boardId = reply.boardId";
		int count = temple.getFetchSize();
		return count;
	}
    /**
     *����»ظ�
     */
	@Override
	public int insertReplyByPublish(Reply reply) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into reply(replyContent) values(?)";
		int row = temple.update(sql);
		return row;
	}

}

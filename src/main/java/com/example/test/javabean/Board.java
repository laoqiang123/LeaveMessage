package com.example.test.javabean;

import java.util.Date;

/**
 * 
 * @author laoqiang
 *
 */
public class Board {
	private Integer boardId;
	private String boardName;
	private User user;
	private String boardContent;
	private Date publishDate;
	private Integer replyCount;
	private Date recentReplyDate;
	

	public Date getRecentReplyDate() {
		return recentReplyDate;
	}

	public void setRecentReplyDate(Date recentReplyDate) {
		this.recentReplyDate = recentReplyDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

}

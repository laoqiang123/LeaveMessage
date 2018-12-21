package com.example.test.javabean;

import java.util.Date;

/**
 * 
 * @author laoqiang
 *
 */
public class Reply {
	private Integer replyId;
	private String replyContent;
	private Board board;
	private Date publishDate;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}

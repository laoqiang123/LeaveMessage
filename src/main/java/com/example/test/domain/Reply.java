package com.example.test.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Reply {
	@NotNull(message="reply must not null")
	private String replyContent;
	private Date addReplyDate;

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getAddReplyDate() {
		return addReplyDate;
	}

	public void setAddReplyDate(Date addReplyDate) {
		this.addReplyDate = addReplyDate;
	}

}

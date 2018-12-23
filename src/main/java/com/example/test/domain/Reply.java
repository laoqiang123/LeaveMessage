package com.example.test.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Reply {
	@NotNull(message="reply must not null")
	@Size(min=6,message="reply must not less six ")
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

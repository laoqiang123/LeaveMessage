package com.example.test.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * 
 * @author laoqiang
 *
 */
public class Board {
	@NotNull(message="boardName must not null")
	@Size(min=6,max=12,message="boardName must betwwn 6 and 12")
	private String boardName;
	@NotNull(message="boardName must not null")
	@Size(min=10,max=150,message="boardName must betwwn 10 and 150")
	private String content;
	private Date publishBoardDate;

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishBoardDate() {
		return publishBoardDate;
	}

	public void setPublishBoardDate(Date publishBoardDate) {
		this.publishBoardDate = publishBoardDate;
	}

}

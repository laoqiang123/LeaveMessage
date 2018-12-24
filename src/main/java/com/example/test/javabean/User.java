package com.example.test.javabean;

/**
 * 
 * @author laoqiang
 *
 */
public class User {
	private Integer userId;
	private String userName;
	private String email;
	private String userPass;
	private Integer active;
	private Integer boardCount;
	private Integer replyCount;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(Integer boardCount) {
		this.boardCount = boardCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

}

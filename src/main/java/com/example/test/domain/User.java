package com.example.test.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author laoqiang
 *
 */
public class User {
	@NotEmpty(message = "username must not null")
	@Size(max = 8, min = 2, message = "username must between 2 to 8 ")
	private String name;
	@Size(min = 6, max = 12, message = "pass must between 6 to 12")
	@NotEmpty(message = "pass must not null")
	private String pass;
	@NotEmpty(message = "newpass must not null")
	@Size(min = 6, max = 12, message = "newpass must between 6 to 12")
	private String newpass;
	@NotEmpty(message = "email must not null")
	private String email;
	@NotEmpty(message="verification must not null")
	private String verification;

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	private Integer active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}

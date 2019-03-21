package com.ankit.assignment.RestUsingMongoDb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserComment {

	private String user;
	private String comment;

	public UserComment(String user, String comment) {
		super();
		this.user = user;
		this.comment = comment;
	}

	public UserComment() {

		// TODO Auto-generated constructor stub
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

package com.ankit.assignment.RestUsingMongoDb.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comments {
	@Id
	private String id;
	@NotNull
	@Indexed (unique = true)
	private String movieId;
	private List<UserComment> userComment;

	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(String id, String movieId, List<UserComment> userComment) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.userComment = userComment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public List<UserComment> getUserComment() {
		return userComment;
	}

	public void setUserComment(List<UserComment> userComment) {
		this.userComment = userComment;
	}

}

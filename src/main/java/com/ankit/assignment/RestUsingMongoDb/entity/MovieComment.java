package com.ankit.assignment.RestUsingMongoDb.entity;

public class MovieComment {
	private Movie movie;
	private Comments comment;

	public MovieComment(Movie movie, Comments comment) {
		super();
		this.movie = movie;
		this.comment = comment;
	}

	public MovieComment() {
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Comments getComment() {
		return comment;
	}

	public void setComment(Comments comment) {
		this.comment = comment;
	}

	
}

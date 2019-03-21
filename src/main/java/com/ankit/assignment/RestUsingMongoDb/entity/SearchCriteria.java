package com.ankit.assignment.RestUsingMongoDb.entity;

public class SearchCriteria {
	public String movieId;
	public String movieName;
	public String dateOfRelease;
	public String actor;
	public String producer;
	public String director;

	public SearchCriteria(String movieId, String movieName, String dateOfRelease, String actor, String producer,
			String director) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.dateOfRelease = dateOfRelease;
		this.actor = actor;
		this.producer = producer;
		this.director = director;
	}

	public SearchCriteria() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(String dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}

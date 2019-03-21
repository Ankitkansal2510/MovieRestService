package com.ankit.assignment.RestUsingMongoDb.entity;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Document(collection = "movie")
public class Movie {
	
	@Id
	private String id;
	@Field
	@Indexed (unique = true)
	private String movieId;
	@NotNull
	@Field
	@Indexed (unique = true)
	private String movieName;
	private String movieDescription;
	@NotNull
	@Field
	private String dateOfRelease;

	private List<String> theaters;
	private Cast cast;

	private int rating;
	@DecimalMin("0.0001")
	private double duration;

	public Movie() {
	}

	public Movie(String id, String movieId, String movieName, String movieDescription, String dateOfRelease,
			List<String> theaters, Cast cast, int rating, double duration) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.dateOfRelease = dateOfRelease;
		this.theaters = theaters;
		this.cast = cast;
		this.rating = rating;
		this.duration = duration;
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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(String dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	public List<String> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<String> theaters) {
		this.theaters = theaters;
	}

	public Cast getCast() {
		return cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}


}

package com.ankit.assignment.RestUsingMongoDb.service;

import java.util.List;

import com.ankit.assignment.RestUsingMongoDb.entity.Movie;

public interface IMovieService {
	List<Movie> findByCriteria(String movieId, String movieName, String dateOfRelease, String actor, String producer,
			String director);

	Movie findById(String id);

	Movie save(Movie movie);

	Movie update(Movie movie);

}

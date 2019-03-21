package com.ankit.assignment.RestUsingMongoDb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankit.assignment.RestUsingMongoDb.entity.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {

	public List<Movie> findByMovieId(String movieId);
	public List<Movie> findByMovieName(String movieName);
	public List<Movie> findByDateOfRelease(String dateOfRelease);
	public List<Movie> findByCast_ActorsIn(String actor);
	public List<Movie> findByCast_ProducersIn(String actor);
	public List<Movie> findByCast_DirectorsIn(String actor);
}
package com.ankit.assignment.RestUsingMongoDb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.assignment.RestUsingMongoDb.entity.Movie;
import com.ankit.assignment.RestUsingMongoDb.repository.MovieRepository;

@Component
@Transactional
public class MovieService implements IMovieService {
	private MovieRepository movieRepository;

	@Autowired
	public MovieService(final MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> findByCriteria(String movieId, String movieName, String dateOfRelease, String actor,
			String producer, String director) {
		List<Movie> movies = null;
		if (movieId != null) {
			movies = movieRepository.findByMovieId(movieId);
		} else if (movieName != null) {
			movies = movieRepository.findByMovieName(movieName);
		} else if (dateOfRelease != null) {
			movies = movieRepository.findByDateOfRelease(dateOfRelease);
		} else if (actor != null) {
			movies = movieRepository.findByCast_ActorsIn(actor);
		} else if (producer != null) {
			movies = movieRepository.findByCast_ProducersIn(producer);
		} else if (director != null) {
			movies = movieRepository.findByCast_DirectorsIn(director);
			
		}
		return movies;
	}

	@Override
	public Movie save(final Movie person) {
		return movieRepository.save(person);
	}

	@Override
	public Movie findById(final String id) {
		List<Movie> movies = movieRepository.findByMovieId(id);

		return movies != null ? movies.get(0) : null;
	}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		Movie movieIndb = findById(movie.getMovieId());

		if (movieIndb == null) {
			return null;
		}
		if (movie.getCast() != null) {
			movieIndb.setCast(movie.getCast());
		}
		if (movie.getDateOfRelease() != null) {
			movieIndb.setDateOfRelease(movie.getDateOfRelease());
		}
		if (movie.getDuration() != 0.0) {
			movieIndb.setDuration(movie.getDuration());
		}
		if (movie.getMovieDescription() != null) {
			movieIndb.setMovieDescription(movie.getMovieDescription());
		}
		if (movie.getMovieName() != null) {
			movieIndb.setMovieName(movie.getMovieName());
		}
		if (movie.getRating() != 0) {
			movieIndb.setRating(movie.getRating());
		}
		if (movie.getTheaters() != null) {
			movieIndb.setTheaters(movie.getTheaters());
		}

		return movieRepository.save(movieIndb);
	}

}

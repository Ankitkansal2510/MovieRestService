package com.ankit.assignment.RestUsingMongoDb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.assignment.RestUsingMongoDb.entity.Comments;
import com.ankit.assignment.RestUsingMongoDb.entity.Movie;
import com.ankit.assignment.RestUsingMongoDb.entity.MovieComment;
import com.ankit.assignment.RestUsingMongoDb.entity.SearchCriteria;
import com.ankit.assignment.RestUsingMongoDb.service.CommentService;
import com.ankit.assignment.RestUsingMongoDb.service.ICommentService;
import com.ankit.assignment.RestUsingMongoDb.service.IMovieService;
import com.ankit.assignment.RestUsingMongoDb.service.MovieService;
import com.ankit.assignment.RestUsingMongoDb.service.NextMovieSequenceService;

@RestController

public class MovieController {

	private IMovieService movieService;
	private ICommentService commentService;
	private NextMovieSequenceService nextMovieSequenceService;
	
	/**
	 * @param movieService
	 */
	@Autowired
	MovieController(final MovieService movieService, final CommentService commentService,NextMovieSequenceService nameSequenceService) {
		this.movieService = movieService;
		this.commentService = commentService;
		this.nextMovieSequenceService = nameSequenceService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> addeMovie(@RequestBody @Valid final Movie movie) {
		movie.setMovieId(String.valueOf(nextMovieSequenceService.getNextSequence("movie_sequence")));
		Movie savedMovie = movieService.save(movie);
		return new ResponseEntity<>("movie added with id " + savedMovie.getMovieId(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> search(@RequestBody SearchCriteria searchCriteria) {
		List<Movie> movies = movieService.findByCriteria(searchCriteria.getMovieId(), searchCriteria.getMovieName(),
				searchCriteria.getDateOfRelease(), searchCriteria.getActor(), searchCriteria.getProducer(),
				searchCriteria.getDirector());
		
		// after retrieving movies , append their comments from comment db
		List<MovieComment> movieComments = appendComments(movies);
		return new ResponseEntity<Object>(movieComments, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET, consumes = "application/json")
	public Movie findById(@PathParam(value = "id") final String id) {
		return movieService.findById(id);
	}

	@RequestMapping(value = "/update/{movieId}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> updateMovie(@PathVariable("movieId") String movieId, @RequestBody final Movie movie) {
		movie.setMovieId(movieId);
		Movie savedMovie = movieService.update(movie);

		return new ResponseEntity<>("movie update with id " + savedMovie.getMovieName(), HttpStatus.ACCEPTED);
		
	}

	@RequestMapping(value = "/createcomment", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> createComment(@RequestBody @Valid final Comments comment) {
		Comments savedComments = commentService.save(comment);
		return new ResponseEntity<>("comment created with id " + savedComments.getMovieId(), HttpStatus.CREATED);
		
	}

	private List<MovieComment> appendComments(List<Movie> movies) {
		List<MovieComment> movieComments = new ArrayList<MovieComment>();
		for (Movie movie : movies) {
			Comments comment = commentService.findByMovieId(movie.getMovieId());
			movieComments.add(new MovieComment(movie, comment));
		}

		return movieComments;
	}
	
	
}

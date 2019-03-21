package com.ankit.assignment.RestUsingMongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankit.assignment.RestUsingMongoDb.entity.Comments;

public interface CommentRepository extends MongoRepository<Comments, String> {

	public Comments findByMovieId(String movieId);
}
package com.ankit.assignment.RestUsingMongoDb.service;

import com.ankit.assignment.RestUsingMongoDb.entity.Comments;

public interface ICommentService {

	Comments findByMovieId(String id);

	Comments save(Comments movie);

}

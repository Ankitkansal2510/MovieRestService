package com.ankit.assignment.RestUsingMongoDb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.assignment.RestUsingMongoDb.entity.Comments;
import com.ankit.assignment.RestUsingMongoDb.repository.CommentRepository;

@Component
@Transactional
public class CommentService implements ICommentService {
	
	private CommentRepository commentRepository;

	@Autowired
	public CommentService(final CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}


	@Override
	public Comments save(Comments comments) {
		return commentRepository.save(comments);
	}

	@Override
	public Comments findByMovieId(final String id) {
		Comments comment = commentRepository.findByMovieId(id);
		
		return comment ;
	}
	
	
	
}

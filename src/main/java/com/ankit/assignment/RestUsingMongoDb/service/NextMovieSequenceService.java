package com.ankit.assignment.RestUsingMongoDb.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ankit.assignment.RestUsingMongoDb.entity.MovieSequence;



@Service
public class NextMovieSequenceService {
	@Autowired
	private MongoOperations mongo;

// https://stackoverflow.com/questions/36448921/how-can-we-create-auto-generated-field-for-mongodb-using-spring-boot
	public int getNextSequence(String seqName) {
		MovieSequence movieSequence = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), MovieSequence.class);
		return movieSequence.getSeq();
	}
}
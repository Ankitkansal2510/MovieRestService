package com.ankit.assignment.RestUsingMongoDb.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cast {

    private List<String> actors;
    private List<String> producers;
    private List<String> directors;
    
	public Cast() {
		// TODO Auto-generated constructor stub
	}

	public Cast(List<String> actors, List<String> producers, List<String> directors) {
		super();
		this.actors = actors;
		this.producers = producers;
		this.directors = directors;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public List<String> getProducers() {
		return producers;
	}

	public void setProducers(List<String> producers) {
		this.producers = producers;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
}

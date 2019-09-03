package com.example.ratingdataservice.models;

public class Movie {
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + "]";
	}

	private String movieId;
	private String name;
	public Movie(String movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

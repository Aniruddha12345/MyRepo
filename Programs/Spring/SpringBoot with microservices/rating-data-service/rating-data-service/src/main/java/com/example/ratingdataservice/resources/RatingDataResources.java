package com.example.ratingdataservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ratingdataservice.models.Movie;
import com.example.ratingdataservice.models.Rating;

@RestController
@RequestMapping("/ratingData")
public class RatingDataResources {
	
	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("demo1/{movieId1}")
	public Rating getRating(@PathVariable("movieId1") String movieId) {

		

		return new Rating(movieId, 4);

	}

	
	// Using RestTemplate to call MovieInfoService to give movie details

	@RequestMapping("demo2/{movieId2}")
	public Movie getMovieDetail(@PathVariable("movieId2") String movieId) {

		// use microservices & call MovieInfoService to give movie Details
		// by this movieId
		
		//RestTemplate restTemplate = new RestTemplate();

		Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + movieId, Movie.class); //not a good practise to hardcode the url, instead put it in property file.

		System.out.println("The movie is---" + movie);

		
		return movie;
	}

}

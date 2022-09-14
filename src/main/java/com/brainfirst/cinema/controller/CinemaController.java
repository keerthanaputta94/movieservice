package com.brainfirst.cinema.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainfirst.cinema.dto.MovieRequest;
import com.brainfirst.cinema.model.Movie;
import com.brainfirst.cinema.service.impl.MovieService;

@RestController
public class CinemaController {
	
	private static final Logger logger = LoggerFactory.getLogger(CinemaController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		logger.info("Inside getAllMovies...");
		List<Movie> movies = movieService.getAllMovies();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/movie/filter/{genre}")
	public ResponseEntity<List<Movie>> getAllFilterMatchedMovies(@PathVariable("genre") String filterBy){
		logger.info("Inside getAllFilterMatchedMovies...");
		List<Movie> movies = movieService.getAllFilterMatchedMovies(filterBy);
		if(movies == null || movies.isEmpty()) {
			logger.info("Inside getAllFilterMatchedMovies no movie found...");
			return new ResponseEntity<>(movies, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable("id") long id){
		logger.info("Inside getMovie...");
		Movie movie = movieService.getMovie(id);
		if(movie == null) {
			logger.info("Inside getMovie no movie found...");
			return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@PostMapping("/movie")
	public ResponseEntity<Movie> createMovie(@RequestBody MovieRequest movieRequest){
		logger.info("Inside createMovie...");
		Movie movie = movieService.createMovie(movieRequest);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id){
		logger.info("Inside deleteMovie...");
		boolean deleted = movieService.deleteMovie(id);
		if(!deleted) {
			logger.info("Inside deleteMovie no movie found...");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/movie/{id}")
	public ResponseEntity<Movie> patchMovie(@PathVariable("id") long id){
		logger.info("Inside patchMovie...");
		Movie movie = movieService.getMovie(id);
		if(movie == null) {
			logger.info("Inside patchMovie no movie found...");
			return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
}

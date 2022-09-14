package com.brainfirst.cinema.service.impl;

import java.util.List;

import com.brainfirst.cinema.dto.MovieRequest;
import com.brainfirst.cinema.model.Movie;

public interface MovieService {
	
	public Movie getMovie(long id);
	public List<Movie> getAllMovies();
	public List<Movie> getAllFilterMatchedMovies(String filterBy);
	public Movie createMovie( MovieRequest movieRequest);
	public boolean deleteMovie(long id);

}

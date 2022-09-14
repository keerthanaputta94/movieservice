package com.brainfirst.cinema.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brainfirst.cinema.dto.MovieRequest;
import com.brainfirst.cinema.model.Movie;
import com.brainfirst.cinema.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie getMovie(long id) {
		Movie movie = null;
		try {
			movie = movieRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			logger.error("Error | ", e);
		} catch(Exception e) {
			logger.error("Error | ", e);
		}
		return movie;
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> getAllFilterMatchedMovies(String filterBy) {
		try {
			return movieRepository.findMovieByRating(Integer.parseInt(filterBy));
		} catch (NumberFormatException e) {
			logger.error("Error | ", e);
		}
		return null;
	}

	@Override
	public Movie createMovie(MovieRequest movieRequest) {
		Movie movie = new Movie();
		movie.setTitle(movieRequest.getTitle());
		movie.setDescription(movieRequest.getDescription());
		movie.setRating(movieRequest.getRating());
		Movie movie2 = movieRepository.save(movie);
		return movie2;
	}

	@Override
	public boolean deleteMovie(long id) {
		try {
			movieRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			logger.error("Error | ", e);
			return false;
		} catch (Exception e) {
			logger.error("Error | ", e);
			return false;
		}
		Movie movie = getMovie(id);
		if(movie ==  null) {
			return true;
		}
		return false;
	}

}

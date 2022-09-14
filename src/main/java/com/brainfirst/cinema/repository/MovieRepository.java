package com.brainfirst.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brainfirst.cinema.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query("SELECT m FROM Movie m WHERE m.rating = ?1")
	List<Movie> findMovieByRating(int status);


}

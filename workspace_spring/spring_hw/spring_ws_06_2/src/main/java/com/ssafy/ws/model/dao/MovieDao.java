package com.ssafy.ws.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.Movie;

@Repository
public interface MovieDao {

	int insert(Movie movie);

	Movie searchById(int id);

	List<Movie> selectAll();

	List<Movie> searchByTitle(String title);

}

package com.ssafy.ws.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.Movie;

@Repository
public interface MovieDao {

	int insert(Movie movie);

	int delete(int id);

	List<Movie> search(String title);

	List<Movie> selectAll();

}

package com.ssafy.ws.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Movie;

public interface MovieService {

	int insert(Movie movie, MultipartFile file) throws IllegalStateException, IOException;

	int delete(int id);

	List<Movie> search(String title);

	List<Movie> selectAll();
}

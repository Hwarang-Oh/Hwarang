package com.ssafy.ws.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.MovieService;
import com.ssafy.ws.model.service.UserService;

@RestController
@RequestMapping("/movieapi")
@CrossOrigin("*")
public class MovieRestController {
	@Autowired
	MovieService ms;

	@Autowired
	UserService us;

	// GetMapping
	// search(READ)
	@GetMapping("/movie/{title}")
	public ResponseEntity<?> select(@PathVariable("title") String title) {
		return new ResponseEntity<List<Movie>>(ms.search(title), HttpStatus.OK);
	}

	@GetMapping("/movie")
	public ResponseEntity<?> selectAll() {
		return new ResponseEntity<List<Movie>>(ms.selectAll(), HttpStatus.OK);
	}

	// PostMapping
	// insert(CREATE)
	@PostMapping("/movie")
	public ResponseEntity<?> insert(@RequestPart("movie") Movie movie,
			@RequestPart(name = "file", required = false) MultipartFile file)
			throws IOException {
		if (ms.insert(movie, file) > 0) {
			return ResponseEntity.created(URI.create("/movieapi" + movie.getTitle())).build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
		/*
		 * try {
		 * ms.insert(movie, file);
		 * return ResponseEntity.created(URI.create("/movieapi" +
		 * movie.getTitle())).build();
		 * } catch (Exception e) {
		 * return ResponseEntity.internalServerError().build();
		 * }
		 */
	}

	// DeleteMapping
	// delete(DELETE)
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (ms.delete(id) > 0) {
			return ResponseEntity.noContent().build();
		} else
			return ResponseEntity.notFound().build();
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// GetMapping
	// select(READ)
	@GetMapping("/user/{id}")
	public ResponseEntity<?> selectUser(@PathVariable("id") String id) {
		return new ResponseEntity<User>(us.select(id), HttpStatus.OK);
	}
}

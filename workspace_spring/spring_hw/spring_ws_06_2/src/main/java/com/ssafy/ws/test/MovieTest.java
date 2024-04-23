package com.ssafy.ws.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

public class MovieTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MovieDao movieDao = context.getBean(MovieDao.class);

		// Test insertion
		// Movie newMovie = new Movie(0, "Inception", "Christopher Nolan", "Sci-Fi",
		// 148, "hi", "bye");
		// movieDao.insert(newMovie);

		// Test retrieval
		Movie retrievedMovie = movieDao.searchById(7);
		System.out.println(retrievedMovie);
	}
}

package main.com.ssafy.ws;

public class Audience {

	private Movie movie;

	public Audience(Movie movie) {
		this.movie = movie;
	}

	public void watch() {
		movie.getInfo();
	}
}

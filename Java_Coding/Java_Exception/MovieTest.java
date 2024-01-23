package com.Movie;

public class MovieTest {
    public static void main(String[] args) {
        Movie myMovie1 = new Movie(1_000_001,"너의이름은", "신카이 마코토", "애니메이션", 190);
        Movie myMovie2 = new Movie(1_000_002,"날씨의아이", "신카이 마코토", "애니메이션", 210);
        Movie myMovie3 = new SeriesMovie(1_000_003,"초속 5cm미터", "신카이 마코토", "애니메이션", 205, 1, "벚꽃 이야기");
        Movie myMovie4 = new SeriesMovie(1_000_004,"초속 5cm미터", "신카이 마코토", "애니메이션", 198, 2, "우주비행사");

        MovieManagerImpl movieManager = MovieManagerImpl.getInstance();

        movieManager.add(myMovie1);
        movieManager.add(myMovie2);
        movieManager.add(myMovie3);
        movieManager.add(myMovie4);

        // getList() Method Test
        for (Movie eachMovie : movieManager.getList()) {
            if (eachMovie != null)
                System.out.println(eachMovie.toString());
        }
        System.out.println("============================================");

        // getMovies() Method Test
        for (Movie eachMovie : movieManager.getMovies()) {
            if (eachMovie != null)
                System.out.println(eachMovie.toString());
        }
        System.out.println("============================================");

        // getSeriesMovies() Method Test
        for (Movie eachMovie : movieManager.getSeriesMovies()) {
            if (eachMovie != null)
                System.out.println(eachMovie.toString());
        }
        System.out.println("============================================");

        try {
	        for (Movie eachMovie : movieManager.searchByTitle("이")) {
	            if (eachMovie != null)
	                System.out.println(eachMovie.toString());
	            }
        } catch (TitleNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        try {
        	for (Movie eachMovie : movieManager.searchByTitle("안녕")) {
	        	if (eachMovie != null)
	                System.out.println(eachMovie.toString());
        	}
        } catch (TitleNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        System.out.println("============================================");

        // getRunningTimeAvg() Method Test
        System.out.println("Running Time Avg : " + movieManager.getRunningTimeAvg() + "(min)");
    }
}
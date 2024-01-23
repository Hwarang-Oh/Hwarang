import java.util.ArrayList;

public interface IMovieManager {
    void add(Movie movie);

    ArrayList<Movie> getList();
    ArrayList<Movie> searchByTitle(String title) throws TitleNotFoundException;
    ArrayList<Movie> getMovies();
    ArrayList<Movie> getSeriesMovies();
    double getRunningTimeAvg();
}
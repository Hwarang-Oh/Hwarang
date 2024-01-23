import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {
    private ArrayList<Movie> movieList = new ArrayList<>();
    private static MovieManagerImpl instance = new MovieManagerImpl();
    public static MovieManagerImpl getInstance() {return instance;}

    public void add(Movie movie){movieList.add(movie);}
    public ArrayList<Movie> getList(){return movieList;}
    public ArrayList<Movie> getMovies(){
        ArrayList<Movie> onlyMovieList = new ArrayList<>();
        for (Movie eachMovie : movieList){
            if (!(eachMovie instanceof SeriesMovie))
                onlyMovieList.add(eachMovie);
        }
        return onlyMovieList;
    }
    public ArrayList<Movie> getSeriesMovies(){
        ArrayList<Movie> onlySeriesList = new ArrayList<>();
        for (Movie eachMovie : movieList) {
            if (eachMovie instanceof SeriesMovie)
                    onlySeriesList.add(eachMovie);
        }
        return onlySeriesList;
    }
    public ArrayList<Movie> searchByTitle(String title) throws TitleNotFoundException {
        ArrayList<Movie> searchedList = new ArrayList<>();
        for (Movie eachMovie : movieList) {
            if (eachMovie.title.contains(title))
                searchedList.add(eachMovie);
        }
        if (searchedList.isEmpty()) throw new TitleNotFoundException(title);
        else return searchedList;
    }
    public double getRunningTimeAvg() {
        double Avg = 0;
        for (Movie eachMovie : movieList) {
                Avg += eachMovie.runningTime;
        }
        return Avg /= movieList.size() * 1.0;
    }
}

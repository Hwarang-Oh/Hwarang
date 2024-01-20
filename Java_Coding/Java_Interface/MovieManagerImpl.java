public class MovieManagerImpl implements IMovieManager {
    static private final int MAX_SIZE = 100;
    private final Movie[] movieList = new Movie[MAX_SIZE];
    private int movieCount = 0;
    private static MovieManagerImpl instance = new MovieManagerImpl();
    public static MovieManagerImpl getInstance() {return instance;}

    public void add(Movie movie){movieList[movieCount++] = movie;
    }
    public Movie[] getList(){return movieList;}
    public Movie[] getMovies(){
        int count = 0;
        Movie[] onlyMovieList = new Movie[MAX_SIZE];
        for (Movie eachMovie : movieList){
            if (eachMovie != null && !(eachMovie instanceof SeriesMovie))
                onlyMovieList[count++] = eachMovie;
        }
        return onlyMovieList;
    }
    public SeriesMovie[] getSeriesMovies(){
        int count = 0;
        SeriesMovie[] onlySeriesList = new SeriesMovie[MAX_SIZE];
        for (Movie eachMovie : movieList) {
            if (eachMovie != null && (eachMovie instanceof SeriesMovie))
                    onlySeriesList[count++] = (SeriesMovie) eachMovie;
        }
        return onlySeriesList;
    }
    public Movie[] searchByTitle(String title){
        int count = 0;
        Movie[] searchedList = new Movie[MAX_SIZE];
        for (Movie eachMovie : movieList) {
            if (eachMovie != null)
                if (eachMovie.title.contains(title))
                    searchedList[count++] = eachMovie;
        }
        return searchedList;
    }
    public double getRunningTimeAvg() {
        double Avg = 0;
        for (Movie eachMovie : movieList) {
            if (eachMovie != null)
                Avg += eachMovie.runningTime;
        }
        return Avg /= movieCount * 1.0;
    }
}

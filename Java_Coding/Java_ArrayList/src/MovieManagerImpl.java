import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MovieManagerImpl implements IMovieManager {
    private static MovieManagerImpl instance = new MovieManagerImpl();
    public static MovieManagerImpl getInstance() {
    	loadData();
    	return instance;}
    private static File target = new File("C:\\Temp\\Movie.dat");
    
    private static ArrayList<Movie> movieList = null;
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
    
    public void saveData() {
    	try(ObjectOutputStream savingList = new ObjectOutputStream(new FileOutputStream(target))) {
    		savingList.writeObject(movieList);
    		System.out.println("영화 리스트 저장 완료");
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private static void loadData() {
    	try(ObjectInputStream savedList = new ObjectInputStream(new FileInputStream(target))) {
    		movieList = (ArrayList<Movie>) savedList.readObject();
    	} catch (IOException e) {
    		System.out.println("불러올 리스트가 없습니다.");
    		movieList = new ArrayList<>();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
}

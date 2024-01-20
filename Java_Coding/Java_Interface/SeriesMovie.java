public class SeriesMovie extends Movie{
    protected int seriesNum;
    protected String episode;

    SeriesMovie(){ // super(); 생성 -> Movie(); 호출
    }
    SeriesMovie(int id, String title, String director, String genre, int runningTime,
                       int seriesNum, String episode){
        super(id, title, director, genre, runningTime);
        this.seriesNum = seriesNum;
        this.episode = episode;
    }
    public int getSeriesNum() {
        return seriesNum;
    }
    public void setSeriesNum(int seriesNum) {
        this.seriesNum = seriesNum;
    }
    public String getEpisode() {
        return episode;
    }
    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String toString() {
        return super.toString() + ", SeriesNum='" + seriesNum + '\''  + ", episode='" + episode + '\'';
    }
}

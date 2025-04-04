package Entity;

public class Movie {
    private String movieName;
    private Integer movieDuration;

    public Movie(String movieName, Integer movieDuration) {
        this.movieName = movieName;
        this.movieDuration = movieDuration;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(Integer movieDuration) {
        this.movieDuration = movieDuration;
    }
}

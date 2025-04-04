package Entity;

import java.util.Map;

public class Show {
    private String showId;
    private Movie movie;
    private String startTime;
    private Map<Seat, Screen> seat;

    public Show(String showId, Movie movie, String startTime, Map<Seat, Screen> seat) {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
        this.seat = seat;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Map<Seat, Screen> getSeat() {
        return seat;
    }

    public void setSeat(Map<Seat, Screen> seat) {
        this.seat = seat;
    }
}

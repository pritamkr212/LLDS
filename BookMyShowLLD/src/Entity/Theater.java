package Entity;

import java.util.List;

public class Theater {
    private String theaterId;
    private String theaterName;
    private Address theaterAddress;
    private List<Screen> screens;
    private List<Show> shows;

    public Theater(String theaterId, String theaterName, Address theaterAddress, List<Screen> screens, List<Show> shows) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.theaterAddress = theaterAddress;
        this.screens = screens;
        this.shows = shows;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public Address getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(Address theaterAddress) {
        this.theaterAddress = theaterAddress;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}

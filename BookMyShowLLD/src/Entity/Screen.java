package Entity;

import java.util.List;
import java.util.Objects;

public class Screen {
    private String screenType;
    private List<Seat> seats;

    public Screen(String screenType, List<Seat> seats) {
        this.screenType = screenType;
        this.seats = seats;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screen screen)) return false;
        return Objects.equals(screenType, screen.screenType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(screenType);
    }
}

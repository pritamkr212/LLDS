package entity;


import enums.GenreType;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Show {
    private String showId;
    private String showName;
    private GenreType genre;
    private List<Slot> slots;

    public Show(String showName, GenreType genre) {
        this.showId = UUID.randomUUID().toString();
        this.showName = showName;
        this.genre = genre;
        this.slots = new ArrayList<>();
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}


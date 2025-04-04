package Respository;

import Entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonolithRepository {
    public static MonolithRepository instance;
    private Map<Address, List<Theater>> theaterAddressMapping;
    private Map<Theater, List<Movie>> theatersMovieMapping;
    private Map<Theater, List<Screen>> theatersScreenMapping;
    private Map<Theater, List<Show>> theaterShowMapping;
    private Map<Show, List<Screen>> showScreenMapping;
    private List<Address> addresses;
    private Map<Movie, Map<List<Theater>, List<Screen>>> getMovieTheaterMapping;
    private List<User> users;

    private MonolithRepository() {
        this.theaterAddressMapping = new HashMap<>();
        this.theatersMovieMapping = new HashMap<>();
        this.theatersScreenMapping = new HashMap<>();
        this.theaterShowMapping = new HashMap<>();
        this.showScreenMapping = new HashMap<>();
        this.addresses = new ArrayList<>();
        this.getMovieTheaterMapping = new HashMap<>();
        this.users = new ArrayList<>();
    }

    public static MonolithRepository getInstance() {
        if (instance == null) {
            instance = new MonolithRepository();
        }
        return instance;
    }

    public static void setInstance(MonolithRepository instance) {
        MonolithRepository.instance = instance;
    }

    public Map<Address, List<Theater>> getTheaterAddressMapping() {
        return theaterAddressMapping;
    }

    public void setTheaterAddressMapping(Map<Address, List<Theater>> theaterAddressMapping) {
        this.theaterAddressMapping = theaterAddressMapping;
    }

    public Map<Theater, List<Movie>> getTheatersMovieMapping() {
        return theatersMovieMapping;
    }

    public Map<Movie, Map<List<Theater>, List<Screen>>> getGetMovieTheaterMapping() {
        return getMovieTheaterMapping;
    }

    public void setGetMovieTheaterMapping(Map<Movie, Map<List<Theater>, List<Screen>>> getMovieTheaterMapping) {
        this.getMovieTheaterMapping = getMovieTheaterMapping;
    }

    public void setTheatersMovieMapping(Map<Theater, List<Movie>> theatersMovieMapping) {
        this.theatersMovieMapping = theatersMovieMapping;
    }

    public Map<Theater, List<Screen>> getTheatersScreenMapping() {
        return theatersScreenMapping;
    }

    public void setTheatersScreenMapping(Map<Theater, List<Screen>> theatersScreenMapping) {
        this.theatersScreenMapping = theatersScreenMapping;
    }

    public Map<Theater, List<Show>> getTheaterShowMapping() {
        return theaterShowMapping;
    }

    public void setTheaterShowMapping(Map<Theater, List<Show>> theaterShowMapping) {
        this.theaterShowMapping = theaterShowMapping;
    }

    public Map<Show, List<Screen>> getShowScreenMapping() {
        return showScreenMapping;
    }

    public void setShowScreenMapping(Map<Show, List<Screen>> showScreenMapping) {
        this.showScreenMapping = showScreenMapping;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

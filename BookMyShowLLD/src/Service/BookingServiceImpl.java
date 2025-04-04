package Service;

import Entity.*;
import Respository.MonolithRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    public static MonolithRepository monolithRepository = MonolithRepository.getInstance();

    @Override
    public Object addAddress(Address address) {
        return monolithRepository.getAddresses().add(address);
    }

    @Override
    public Object addTheater(Address address, List<Theater> theaters) {
        return monolithRepository.getTheaterAddressMapping().put(address, new ArrayList<>(theaters));
    }


    @Override
    public Object addScreen(Theater theater, List<Screen> screens) {
        return monolithRepository.getTheatersScreenMapping().put(theater, screens);
    }


    @Override
    public Object addMovie(Movie movie, Map<List<Theater>, List<Screen>> theaterShowMapping) {
        return monolithRepository.getGetMovieTheaterMapping().put(movie, theaterShowMapping);
    }

    @Override
    public Object bookShow(Show show, Theater theater) {
        List<Screen> screens = theater.getScreens();
        Map<Seat, Screen> seatMap = show.getSeat();
        for (Map.Entry<Seat, Screen> entry : seatMap.entrySet()) {
            Seat seat = entry.getKey();
            Screen screen = entry.getValue();
            screens.stream()
                    .filter(x -> x.equals(screen))
                    .map(x -> {
                        List<Seat> seats = x.getSeats();
                        if (seats.contains(seat)) {
                            if(!seat.getBooked()){
                                seat.setBooked(true);
                                System.out.println(seat.getSeatNo() + " is Booked Finally");
                            }
                            else{
                                System.out.println("Already Booked");
                            }
                            return true;
                        }
                        return false;
                    }).filter(x -> x).collect(Collectors.toList());
        }
        return null;

    }


    @Override
    public Object getAllAvailableSeat(Show show, Theater theater, Screen screen) {
        if (theater.getShows().contains(show)) {
            List<Screen> screens = theater.getScreens().stream()
                    .filter(screen1 -> screen1.equals(screen)) // Ensure correct screen comparison
                    .filter(screen1 -> theater.getShows().contains(show)) // Check if show exists in theater
                    .collect(Collectors.toList());
            return screens.get(0).getSeats().stream().filter(x -> !x.getBooked()).toList();
        } else {
            System.out.println("Error in get All available Seat");
            return null;
        }

    }


    @Override
    public Object addUser(User user) {
        return monolithRepository.getUsers().add(user);
    }

    @Override
    public Object getAllShow(Theater theater) {
        return theater.getShows();
    }
}

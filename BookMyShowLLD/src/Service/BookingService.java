package Service;

import Entity.*;

import java.util.List;
import java.util.Map;

/**
 * The interface Booking service.
 */
public interface BookingService {

    Object addAddress(Address address);

    Object addTheater(Address address, List<Theater> theaters);

    Object addScreen(Theater theater, List<Screen> screens);


    Object addMovie(Movie movie, Map<List<Theater>, List<Screen>> theaterShowMapping);

    Object bookShow(Show show, Theater theater);

    Object getAllAvailableSeat(Show show, Theater theater, Screen screen);

    Object addUser(User user);

    Object getAllShow(Theater theater);
}

package Service;

import Entity.*;

import java.util.List;
import java.util.Map;

/**
 * The interface Booking service.
 */
public interface BookingService {
    /**
     * Add address object.
     *
     * @param address the address
     * @return the object
     */
    Object addAddress(Address address);

    /**
     * Add theater object.
     *
     * @param address  the address
     * @param theaters the theaters
     * @return the object
     */
    Object addTheater(Address address, List<Theater> theaters);

    /**
     * Add screen object.
     *
     * @param theater the theater
     * @param screens the screens
     * @return the object
     */
    Object addScreen(Theater theater, List<Screen> screens);

    /**
     * Add movie object.
     *
     * @param movie              the movie
     * @param theaterShowMapping the theater show mapping
     * @return the object
     */
    Object addMovie(Movie movie, Map<List<Theater>, List<Screen>> theaterShowMapping);

    /**
     * Book show object.
     *
     * @param show    the show
     * @param theater the theater
     * @return the object
     */
    Object bookShow(Show show, Theater theater);

    /**
     * All available seat object.
     *
     * @param show    the show
     * @param theater the theater
     * @param screen  the screen
     * @return the object
     */
    Object getAllAvailableSeat(Show show, Theater theater, Screen screen);

    /**
     * Add user object.
     *
     * @param user the user
     * @return the object
     */
    Object addUser(User user);

    /**
     * Gets all show.
     *
     * @param theater the theater
     * @return the all show
     */
    Object getAllShow(Theater theater);
}

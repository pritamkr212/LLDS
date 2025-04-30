import Entity.*;
import Service.BookingService;
import Service.BookingServiceImpl;
import Service.PaymentService;
import Service.PaymentServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Service.BookingServiceImpl.shutdownExecutor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BookingService bookingService = new BookingServiceImpl();


        User user = new User("3456", "JohnDoe123", "johy", "M", 30);
        Address address = new Address("Bangalore", "Karnataka");
        Movie movie = new Movie("1", 180);

        List<Seat> seatList = new ArrayList<>();
        Seat seat1 = new Seat("S101", "A1", false);
        Seat seat2 = new Seat("S102", "A2", false);
        Seat seat3 = new Seat("S103", "B1", false);
        seatList.add(seat1);
        seatList.add(seat2);
        seatList.add(seat3);

        List<Screen> screenList = new ArrayList<>();
        Screen screen1 = new Screen("101", new ArrayList<>(seatList));
        Screen screen2 = new Screen("102", new ArrayList<>(seatList));
        screenList.add(screen1);
        screenList.add(screen2);

        Map<Seat, Screen> seatScreenMap = new HashMap<>();
        seatScreenMap.put(seat1, screen1);
        seatScreenMap.put(seat2, screen2);
        seatScreenMap.put(seat3, screen1);

        List<Show> showList = new ArrayList<>();
        Show show1 = new Show("201", movie, "18:00", new HashMap<>(seatScreenMap));
        Show show2 = new Show("202", movie, "21:00", new HashMap<>(seatScreenMap));
        Show show3 = new Show("203", movie, "23:30", new HashMap<>(seatScreenMap));
        showList.add(show1);
        showList.add(show2);
        showList.add(show3);

        List<Theater> theaterList = new ArrayList<>();
        Theater theater = new Theater("hjj", "PVR Cinemas", address, new ArrayList<>(screenList), new ArrayList<>(showList));
        theaterList.add(theater);

        bookingService.addAddress(address);
        Map<List<Theater>, List<Screen>> theaterScreenMap = new HashMap<>();
        theaterScreenMap.put(theaterList, new ArrayList<>(screenList));
        bookingService.addMovie(movie, theaterScreenMap);

        bookingService.addScreen(theater, new ArrayList<>(screenList));

        bookingService.bookShow(show1, theater);
        PaymentService paymentService = new PaymentServiceImpl();
        paymentService.acceptCash(500);
        bookingService.bookShow(show2, theater);
        ((BookingServiceImpl) bookingService).shutdownExecutor();

        System.out.println(bookingService.getAllAvailableSeat(show1, theater, screen1));

    }
}
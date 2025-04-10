package Service;

import Entity.*;
import Respository.MonolithRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService, Runnable {

    public static MonolithRepository monolithRepository = MonolithRepository.getInstance();

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private Show show;
    private Theater theater;
    private Seat seatToBook;

    public BookingServiceImpl() {}

    public BookingServiceImpl(Show show, Theater theater, Seat seatToBook) {
        this.show = show;
        this.theater = theater;
        this.seatToBook = seatToBook;
    }

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

        List<Future<?>> futures = new ArrayList<>();

        for (Map.Entry<Seat, Screen> entry : seatMap.entrySet()) {
            Seat seat = entry.getKey();
            Screen screen = entry.getValue();

            Future<?> future = executorService.submit(() -> {
                screens.stream()
                        .filter(x -> x.equals(screen))
                        .map(x -> {
                            List<Seat> seats = x.getSeats();
                            if (seats.contains(seat)) {
                                synchronized (seat) {
                                    if (!seat.getBooked()) {
                                        seat.setBooked(true);
                                        System.out.println(Thread.currentThread().getName() + " -> Booked Seat: " + seat.getSeatNo());
                                    } else {
                                        System.out.println(Thread.currentThread().getName() + " -> Seat already booked: " + seat.getSeatNo());
                                    }
                                }
                                return true;
                            }
                            return false;
                        }).filter(x -> x).collect(Collectors.toList());
            });

            futures.add(future);
        }

        // Optional: wait for all tasks to complete (if needed)
        for (Future<?> future : futures) {
            try {
                future.get(); // wait for completion
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Object getAllAvailableSeat(Show show, Theater theater, Screen screen) {
        if (theater.getShows().contains(show)) {
            List<Screen> screens = theater.getScreens().stream()
                    .filter(screen1 -> screen1.equals(screen))
                    .filter(screen1 -> theater.getShows().contains(show))
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

    @Override
    public void run() {
        if (show != null && theater != null && seatToBook != null) {
            show.getSeat().put(seatToBook, theater.getScreens().get(0));
            bookShow(show, theater);
        }
    }

    public static void shutdownExecutor() {
        executorService.shutdown();
    }
}

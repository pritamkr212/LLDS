import enums.GenreType;
import enums.UserType;
import service.*;
import service.impl.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserService userService = new UserServiceImpl();
        ShowService showService = new ShowServiceImpl();
        BookingService bookingService = new BookingServiceImpl();
        SlotService slotService = new SlotServiceImpl();
        SearchService searchService = new SearchServiceImpl();

        // 1. Create Organizer and Customer Users
        userService.registerUser("Organizer1", UserType.ORGANIZER);
        userService.registerUser("Customer1", UserType.CUSTOMER);
        userService.registerUser("Customer2", UserType.CUSTOMER);
        userService.registerUser("Customer3", UserType.CUSTOMER);

        LocalDateTime now = LocalDateTime.now();
        // 2. Organizer creates a Show and Slots
        showService.createShow("Organizer1", "TMKOC", GenreType.COMEDY);
        slotService.createSlot("Organizer1", "TMKOC", now, 4);
        slotService.createSlot("Organizer1", "TMKOC", now, 2);
        slotService.createSlot("Organizer1", "TMKOC", now.plusHours(1), 3);

        showService.createShow("Organizer1", "The Sonu Nigam Live Event", GenreType.SINGING);
        slotService.createSlot("Organizer1", "The Sonu Nigam Live Event", now, 2);
        slotService.createSlot("Organizer1", "The Sonu Nigam Live Event", now, 2);
        slotService.createSlot("Organizer1", "The Sonu Nigam Live Event", now.plusHours(1), 3);

        // 3. Customers try booking
        bookingService.bookTicket("Customer1", "TMKOC", now, 1); // Successful
        bookingService.bookTicket("Customer2", "TMKOC", now, 4); // Successful
        bookingService.bookTicket("Customer3", "The Sonu Nigam Live Event", now, 1); // Should go to waitlist
        Thread.sleep(1000);


        // 4. Customer2 cancels
        bookingService.cancelTicket(1);
        Thread.sleep(1000);

        searchService.showAvailableByGenre(GenreType.COMEDY);
        searchService.showAvailableByGenre(GenreType.SINGING);

        Thread.sleep(5000);
        ((BookingServiceImpl) bookingService).terminate();

    }
}
package service.impl;

import entity.Show;
import entity.Slot;
import entity.User;
import enums.UserType;
import respository.ShowRepository;
import respository.SlotRepository;
import respository.UserRepository;
import service.SlotService;

import java.time.LocalDateTime;

import static Utils.Utility.generateSlotKey;

public class SlotServiceImpl implements SlotService {
    private final SlotRepository slotRepository = SlotRepository.getInstance();
    private final ShowRepository showRepository = ShowRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();

    public void createSlot(String organizerName, String showName, LocalDateTime startTime, int capacity) {
        User organizer = userRepository.getUser(organizerName);
        if (organizer == null || organizer.getUserType() != UserType.ORGANIZER) {
            throw new IllegalArgumentException("Only ORGANIZER can create slots.");
        }

        Show show = showRepository.getShow(showName);
        if (show == null) {
            throw new IllegalArgumentException("Show does not exist.");
        }
        String key = generateSlotKey(showName, startTime.toString());
        if (isSlotAvailable(key)) {
            Slot slot = new Slot();
            slot.setShowName(showName);
            slot.setStartTime(startTime.toString());
            slot.setEndTime(startTime.plusHours(1).toString());
            slot.setCapacity(capacity);
            slot.setAvailableCapacity(capacity);
            slotRepository.addSlot(key, slot);
            show.getSlots().add(slot);
        }
    }

    @Override
    public Slot getSlot(String showName, String startTime) {
        return slotRepository.getSlot(generateSlotKey(showName, startTime));
    }

    private boolean isSlotAvailable(String key) {
        if (slotRepository.getSlot(key) != null) {
            System.out.println("Slot already exists for this time and key " + key);
            return false;
        }
        return true;
    }

    public String getTiming(Slot slot) {
        return slot.getStartTime() + "-" + slot.getEndTime();
    }

}
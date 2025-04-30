package service;

import entity.Slot;

import java.time.LocalDateTime;

/**
 * The interface Slot service.
 */
public interface SlotService {
    /**
     * Create slot.
     *
     * @param organizerName the organizer name
     * @param showName      the show name
     * @param startTime     the start time
     * @param capacity      the capacity
     */
    void createSlot(String organizerName, String showName, LocalDateTime startTime, int capacity);

    /**
     * Gets slot.
     *
     * @param showName  the show name
     * @param startTime the start time
     * @return the slot
     */
    Slot getSlot(String showName, String startTime);
}

package service;

import entity.DisplayBoard;

/**
 * The interface Observer board.
 */
public interface Observer {
    /**
     * Update display board.
     *
     * @param parkingSlotName the parking slot name
     */
    void updateObserverBoard(String parkingSlotName);
}

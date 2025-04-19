package Utils;

import entity.Slot;
import respository.SlotRepository;

public class Utility {
    private final SlotRepository slotRepository = SlotRepository.getInstance();

    public static String generateSlotKey(String showName, String startTime) {
        return showName + "_" + startTime;
    }
}

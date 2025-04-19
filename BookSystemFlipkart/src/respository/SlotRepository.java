package respository;

import entity.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotRepository {
    private static SlotRepository instance;
    private final Map<String, Slot> slots = new HashMap<>();

    private SlotRepository() {}

    public static SlotRepository getInstance() {
        if (instance == null) {
            instance = new SlotRepository();
        }
        return instance;
    }

    public void addSlot(String key, Slot slot) {
        slots.put(key, slot);
    }

    public Slot getSlot(String key) {
        return slots.get(key);
    }
    public List<Slot> getAllSlots(){
        return new ArrayList<>(slots.values());
    }
}
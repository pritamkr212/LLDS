package entity;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class EntrancePanel {
    private AtomicInteger x = new AtomicInteger(0);
    private String entranceName;
    private int entranceId;

    public EntrancePanel(String entranceName) {
        this.entranceName = entranceName;
        this.entranceId = x.getAndIncrement();
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName;
    }

    public int getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(int entranceId) {
        this.entranceId = entranceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntrancePanel that)) return false;
        return Objects.equals(entranceName, that.entranceName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(entranceName);
    }
}

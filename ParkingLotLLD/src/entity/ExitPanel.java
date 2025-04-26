package entity;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ExitPanel {
    private AtomicInteger x = new AtomicInteger(0);
    private String exitName;
    private int exitId;

    public ExitPanel(String exitName) {
        this.exitName = exitName;
        this.exitId = x.incrementAndGet();
    }


    public String getExitName() {
        return exitName;
    }

    public void setExitName(String exitName) {
        this.exitName = exitName;
    }

    public int getExitId() {
        return exitId;
    }

    public void setExitId(int exitId) {
        this.exitId = exitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExitPanel exitPanel)) return false;
        return Objects.equals(exitName, exitPanel.exitName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(exitName);
    }
}

package entity;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;

    public ParkingLot(String name) {
        this.name = name;
        this.entrancePanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntrancePanel> getEntrancePanels() {
        return entrancePanels;
    }

    public void setEntrancePanels(List<EntrancePanel> entrancePanels) {
        this.entrancePanels = entrancePanels;
    }

    public List<ExitPanel> getExitPanels() {
        return exitPanels;
    }

    public void setExitPanels(List<ExitPanel> exitPanels) {
        this.exitPanels = exitPanels;
    }

}

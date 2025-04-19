package entity;


import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Slot {
    private String showName;
    private String startTime;
    private String endTime;
    private int capacity;
    private int availableCapacity;
    private BlockingQueue<Booking> waitlist = new LinkedBlockingQueue<>();


    public Slot(String showName, String startTime, int capacity) {
        this.showName = showName;
        this.startTime = startTime;
        this.capacity = capacity;
        this.availableCapacity = capacity;
    }

    public Slot() {
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public BlockingQueue<Booking> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(BlockingQueue<Booking> waitlist) {
        this.waitlist = waitlist;
    }
}



package Entity;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private List<Appointment>bookAppointment;

    public Patient(String name) {
        this.name = name;
        bookAppointment = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment> getBookAppointment() {
        return bookAppointment;
    }

    public void setBookAppointment(List<Appointment> bookAppointment) {
        this.bookAppointment = bookAppointment;
    }

}

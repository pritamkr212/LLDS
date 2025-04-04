package Entity;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private Specialization specialization;
    private List<Appointment>appointments;
    private List<String> availableSlot;

    public Doctor(String name, Specialization specialization) {
        this.name = name;
        this.specialization = specialization;
        appointments = new ArrayList<>();
        availableSlot =new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<String> getAvailableSlot() {
        return availableSlot;
    }

    public void setAvailableSlot(List<String> availableSlot) {
        this.availableSlot = availableSlot;
    }
}

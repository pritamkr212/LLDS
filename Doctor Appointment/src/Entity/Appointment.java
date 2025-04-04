package Entity;

import java.lang.constant.DynamicCallSiteDesc;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String id;
    private String slot;

    public Appointment(Doctor doctor, Patient patient, String id, String slot) {
        this.doctor = doctor;
        this.patient = patient;
        this.id = id;
        this.slot = slot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}

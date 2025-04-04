package repository;

import Entity.Appointment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppointmentRepository {
    private static Map<String, Appointment> appointmentMap = new ConcurrentHashMap<>();
    public static AppointmentRepository instance;

    public static AppointmentRepository getInstance() {
        if (instance == null) {
            synchronized (AppointmentRepository.class) {
                return new AppointmentRepository();
            }
        }
        return instance;
    }

    public static Map<String, Appointment> getAppointMap() {
        return appointmentMap;
    }
}

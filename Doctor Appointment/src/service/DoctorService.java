package service;

import Entity.Doctor;
import repository.DoctorRepository;

import java.util.Map;

public class DoctorService {
    private static DoctorService instance;

    public static DoctorService getInstance() {
        if (instance == null) {
            synchronized (DoctorService.class) {
                instance = new DoctorService();
            }
        }
        return instance;
    }

    private Map<String, Doctor> doctorMap = DoctorRepository.getInstance().getDoctorMap();

    public void addDoctor(Doctor doctor) {
        doctorMap.put(doctor.getName(), doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctorMap.remove(doctor.getName());
    }

    public void addSlot(Doctor doctor, String slot) {
        doctor.getAvailableSlot().add(slot);
    }

    public void removeSlot(Doctor doctor, String slot) {
        doctor.getAvailableSlot().remove(slot);
    }


}

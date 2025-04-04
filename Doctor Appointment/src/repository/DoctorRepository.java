package repository;

import Entity.Doctor;
import Entity.Patient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DoctorRepository {

    private static Map<String, Doctor> doctorMap = new ConcurrentHashMap<>();
    public static DoctorRepository instance;

    public static DoctorRepository getInstance() {
        if (instance == null) {
            synchronized (DoctorRepository.class) {
                return new DoctorRepository();
            }
        }
        return instance;
    }

    public static Map<String, Doctor> getDoctorMap() {
        return doctorMap;
    }
}

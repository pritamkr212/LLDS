package repository;

import Entity.Patient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PatientRepository {
    private static Map<String, Patient> patientMap = new ConcurrentHashMap<>();
    public static PatientRepository instance;

    public static PatientRepository getInstance() {
        if (instance == null) {
            synchronized (PatientRepository.class) {
                return new PatientRepository();
            }
        }
        return instance;
    }

    public static Map<String, Patient> getPatientMap() {
        return patientMap;
    }
}

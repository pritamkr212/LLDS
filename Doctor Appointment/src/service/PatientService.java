package service;

import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import repository.PatientRepository;

import java.util.Map;

public class PatientService {
    private static PatientService instance;

    public static PatientService getInstance() {
        if (instance == null) {
            synchronized (PatientService.class) {
                instance = new PatientService();
            }
        }
        return instance;
    }

    private Map<String, Patient> patientMap = PatientRepository.getInstance().getPatientMap();
    public void addPatient(Patient patient) {
        patientMap.put(patient.getName(), patient);
    }
    public void removePatient(Patient patient) {
        patientMap.remove(patient.getName());
    }
}

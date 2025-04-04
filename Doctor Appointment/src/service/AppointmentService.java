package service;

import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import repository.AppointmentRepository;
import repository.DoctorRepository;
import repository.PatientRepository;

import java.util.Map;

public class AppointmentService {
    private static AppointmentService instance;

    public static AppointmentService getInstance() {
        if (instance == null) {
            synchronized (AppointmentService.class) {
                instance = new AppointmentService();
            }
        }
        return instance;
    }
    private Map<String, Appointment> appointmentMap = AppointmentRepository.getInstance().getAppointMap();
    private Map<String, Doctor> doctorMap = DoctorRepository.getInstance().getDoctorMap();
    private Map<String, Patient> patientMap = PatientRepository.getInstance().getPatientMap();

    public void addAppointment(Appointment appointment) {
        appointmentMap.put(appointment.getId(), appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointmentMap.remove(appointment.getId());
    }

    public void bookAppointment(Appointment appointment) {
        if(appointment.getDoctor()!=null && appointment.getPatient()!=null) {
            Doctor doctor = doctorMap.get(appointment.getDoctor().getName());
            if (doctor != null) {
                if (doctor.getAvailableSlot().contains(appointment.getSlot())) {
                    doctor.getAvailableSlot().remove(appointment.getSlot());
                    doctor.getAppointments().add(appointment);
                    patientMap.get(appointment.getPatient().getName()).getBookAppointment().add(appointment);
                    System.out.println("Successfully Booked Appointment");
                } else {
                    System.out.println("Slot already booked");
                }
            }
        }else{
            System.out.println("Something went wrong");
        }
    }

    public void cancelAppointment(Appointment appointment) {
        Doctor doctor = doctorMap.get(appointment.getDoctor().getName());
        if (doctor != null) {
            if (doctor.getAvailableSlot().contains(appointment.getSlot())) {
                doctor.getAvailableSlot().add(appointment.getSlot());
                doctor.getAppointments().remove(appointment);
                patientMap.get(appointment.getPatient().getName()).getBookAppointment().remove(appointment);
            } else {
                System.out.println("Already unBooked");
            }
        }
    }

}

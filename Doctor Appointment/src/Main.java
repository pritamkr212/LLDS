import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import Entity.Specialization;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        AppointmentService appointmentService = AppointmentService.getInstance();
        DoctorService doctorService = DoctorService.getInstance();
        PatientService patientService = PatientService.getInstance();

        Doctor doctor1 = new Doctor("Ram", Specialization.CARDIOLOGIST);
        doctorService.addDoctor(doctor1);
        doctorService.addSlot(doctor1, "9:00-10:00");
        doctorService.addSlot(doctor1, "19:00-21:00");
        doctorService.addSlot(doctor1, "7:00-8:00");

        Patient patient1=new Patient("shayam");
        Patient patient2=new Patient("kjhg");
        Patient patient3=new Patient("ertyui");
        patientService.addPatient(patient1);
        patientService.addPatient(patient2);
        patientService.addPatient(patient3);

        Appointment appointment1=new Appointment(doctor1,patient1, UUID.randomUUID().toString(),"9:00-10:00");
        Appointment appointment2=new Appointment(doctor1,patient2, UUID.randomUUID().toString(),"9:00-10:00");

        appointmentService.bookAppointment(appointment1);
        appointmentService.bookAppointment(appointment2);
    }
}
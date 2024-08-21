package Homework_lesson7;

import javax.print.Doc;
import java.util.Arrays;

public class Hospital {
    private Doctor[] doctors;
    private Patient[] patients;
    private Printer printer;

    {
        this.doctors = new Doctor[0];
        this.patients = new Patient[0];
    }

    public Hospital(Printer printer, Doctor... doctors) {
        this.doctors = doctors;
        this.printer = printer;
    }

    public void hireDoctor(Doctor doctor) {
        int length = this.doctors.length;
        this.doctors = Arrays.copyOf(this.doctors, length + 1);
        this.doctors[length] = doctor;
    }

    public void addPatients(Patient... newPatients) {
        Patient[] result = Arrays.copyOf(this.patients, this.patients.length + newPatients.length);
        System.arraycopy(newPatients, 0, result, this.patients.length, newPatients.length);
        this.patients = result;
    }

    public void treatmentProcess() {
        Therapist therapist = (Therapist) Helpers.getDoctorByClass(this.doctors, Therapist.class);

        if (therapist == null) {
            this.printer.error("Error Our hospital don't have a therapist");
            return;
        }

        for (Patient patient : this.patients) {

            if (patient.isHealthy()) {
                this.printer.info(patient.getName() + " is healthy");
                continue;
            }
            therapist.assignPatientToDoctor(patient, this.doctors);

            Doctor doctor = patient.getDoctor();
            if (doctor == null) {
                this.printer.error("the patient " + patient.getName() + " has not been assigned a doctor");
                continue;
            }

            doctor.treatmentProcess(patient);
        }
    }


}

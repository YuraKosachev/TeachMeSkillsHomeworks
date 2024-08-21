package Homework_lesson7;

import java.util.Random;

public class Therapist extends Doctor {
    public Therapist(String name) {
        super(name);
    }

    @Override
    public void treatmentProcess(Patient patient) {
        Printer.action("Therapist start treatment process");
        preparingPatientToCheckOut(patient);
        Printer.action("Therapist end treatment process..");
        Printer.info(patient.getName() + " ready to check out!");
    }

    public void assignPatientToDoctor(Patient patient, Doctor[] doctors) {

        if (patient.isHealthy())
            return;

        Random random = new Random();
        int code = random.nextInt(0, 4);

        Doctor doctor = null;

        switch (code) {
            case 1 -> doctor = Helpers.getDoctorByClass(doctors, Surgeon.class);
            case 2 -> doctor = Helpers.getDoctorByClass(doctors, Dentist.class);
            default -> doctor = this;
        }

        if (doctor == null) {
            Printer.error("Our hospital don't have a such doctor");
            return;
        }

        patient.setDoctor(doctor);
        patient.setTreatmentPlan(code);
        Printer.info("Therapist " + this.getName() + " set plan:" + patient.getPlan() + " and appointed a doctor to the patient " + patient.getName());
    }
}

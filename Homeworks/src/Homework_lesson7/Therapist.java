package Homework_lesson7;

import java.util.Random;

public class Therapist extends Doctor {
    public Therapist(String name, Printer printer) {
        super(name, printer);
    }

    @Override
    public void treatmentProcess(Patient patient) {
        printer.action("Therapist start treatment process");
        preparingPatientToCheckOut(patient);
        printer.action("Therapist end treatment process..");
        printer.info(patient.getName() + " ready to check out!");
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
            printer.error("Our hospital don't have a such doctor");
            return;
        }

        patient.setDoctor(doctor);
        patient.setTreatmentPlan(code);
        printer.info("Therapist " + this.getName() + " set plan:" + patient.getPlan() + " and appointed a doctor to the patient " + patient.getName());
    }
}

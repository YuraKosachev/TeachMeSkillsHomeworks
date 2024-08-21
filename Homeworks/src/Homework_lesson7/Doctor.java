package Homework_lesson7;

import javax.print.Doc;

public class Doctor extends Person {
    public Doctor(String name){
        super(name);
    }

    public void treatmentProcess(Patient patient){
        Printer.action("Doctor treats");
    }
    protected final void preparingPatientToCheckOut(Patient patient){
        patient.setDoctor(null);
        patient.setHealthyStatus(true);
        patient.setTreatmentPlan(-1);
    }
}

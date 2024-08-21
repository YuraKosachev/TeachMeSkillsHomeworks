package Homework_lesson7;

import javax.print.Doc;

public class Doctor extends Person {
    protected Printer printer;
    public Doctor(String name, Printer printer){
        super(name);
        this.printer = printer;
    }

    public void treatmentProcess(Patient patient){
        printer.action("Doctor treats");
    }
    protected final void preparingPatientToCheckOut(Patient patient){
        patient.setDoctor(null);
        patient.setHealthyStatus(true);
        patient.setTreatmentPlan(-1);
    }
}

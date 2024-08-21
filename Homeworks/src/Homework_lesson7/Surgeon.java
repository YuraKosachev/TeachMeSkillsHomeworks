package Homework_lesson7;

public class Surgeon extends Doctor{
    public Surgeon(String name, Printer printer){
        super(name, printer);
    }

    @Override
    public void treatmentProcess(Patient patient) {
        printer.action("Surgeon start treatment process");
        preparingPatientToCheckOut(patient);
        printer.action("Surgeon end treatment process..");
        printer.info(patient.getName() + " ready to check out!");
    }
}

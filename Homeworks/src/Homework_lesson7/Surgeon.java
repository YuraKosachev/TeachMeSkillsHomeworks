package Homework_lesson7;

public class Surgeon extends Doctor{
    public Surgeon(String name){
        super(name);
    }

    @Override
    public void treatmentProcess(Patient patient) {
        Printer.action("Surgeon start treatment process");
        preparingPatientToCheckOut(patient);
        Printer.action("Surgeon end treatment process..");
        Printer.info(patient.getName() + " ready to check out!");
    }
}

package Homework_lesson7;

public class Dentist extends Doctor{
    public Dentist(String name){
        super(name);
    }

    @Override
    public void treatmentProcess(Patient patient) {
        Printer.action("Dentist start treatment process");
        preparingPatientToCheckOut(patient);
        Printer.action("Dentist end treatment process..");
        Printer.info(patient.getName() + " ready to check out!");
    }
}

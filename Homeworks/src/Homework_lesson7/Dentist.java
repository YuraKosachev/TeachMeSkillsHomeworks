package Homework_lesson7;

public class Dentist extends Doctor{
    public Dentist(String name, Printer printer){
        super(name,printer);
    }

    @Override
    public void treatmentProcess(Patient patient) {
        printer.action("Dentist start treatment process");
        preparingPatientToCheckOut(patient);
        printer.action("Dentist end treatment process..");
        printer.info(patient.getName() + " ready to check out!");
    }
}

package Homework_lesson7;

import java.lang.reflect.Field;

public class HomeWorkLesson7 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        //Task 1
        startHospitalTask(printer);

        //Task2
        appleTask(printer);
    }

    //Task1
    private static void startHospitalTask(Printer printer) {

        Therapist therapist = new Therapist("Курчатов Василий", printer);
        Dentist dentist = new Dentist("Иванов Иван", printer);
        Surgeon surgeon = new Surgeon("Федоров Дмитрий", printer);

        Patient patient1 = new Patient("Фролов Виталий");
        Patient patient2 = new Patient("Быстрова Ирина");
        Patient patient3 = new Patient("Мисса Павел");
        Patient patient4 = new Patient("Деркач Ольга");
        Patient patient5 = new Patient("Плевако Виталий");
        Patient patient6 = new Patient("Шпаковская Наталья");

        Hospital hospital = new Hospital(printer, therapist, dentist, surgeon);

        hospital.addPatients(patient1, patient2, patient3, patient4, patient5, patient6);

        hospital.treatmentProcess();
    }

    //Task2
    private static void appleTask(Printer printer) {
        Apple apple = new Apple();
        printer.info("Old color value: " + apple.getColor());

        try {
            //use reflection to change value
            Field field = apple.getClass().getDeclaredField("color");
            field.setAccessible(true);
            field.set(apple, "Blue"); // set new value
            printer.info("New color value: " + apple.getColor());

        } catch (Exception ex) {
            printer.error("Error: " + ex.getMessage());
        }
    }

}

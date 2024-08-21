package Homework_lesson7;

import java.lang.reflect.Field;

public class HomeWorkLesson7 {
    public static void main(String[] args) {
        //Task 1
        startHospitalTask();

        //Task2
        appleTask();
    }

    //Task1
    private static void startHospitalTask() {

        Therapist therapist = new Therapist("Курчатов Василий");
        Dentist dentist = new Dentist("Иванов Иван");
        Surgeon surgeon = new Surgeon("Федоров Дмитрий");

        Patient patient1 = new Patient("Фролов Виталий");
        Patient patient2 = new Patient("Быстрова Ирина");
        Patient patient3 = new Patient("Мисса Павел");
        Patient patient4 = new Patient("Деркач Ольга");
        Patient patient5 = new Patient("Плевако Виталий");
        Patient patient6 = new Patient("Шпаковская Наталья");

        Hospital hospital = new Hospital(therapist, dentist, surgeon);

        hospital.addPatients(patient1, patient2, patient3, patient4, patient5, patient6);

        hospital.treatmentProcess();
    }

    //Task2
    private static void appleTask() {
        Apple apple = new Apple();
        Printer.info("Old color value: " + apple.getColor());

        try {
            //use reflection to change value
            Field field = apple.getClass().getDeclaredField("color");
            field.setAccessible(true);
            field.set(apple, "Blue"); // set new value
            Printer.info("New color value: " + apple.getColor());

        } catch (Exception ex) {
            Printer.error("Error: " + ex.getMessage());
        }
    }

}

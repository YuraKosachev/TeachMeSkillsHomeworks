package Homework_lesson7;

public final class Helpers {

    public static final Doctor getDoctorByClass(Doctor[] doctors, Class doctorClass){
        for(Doctor doctor : doctors ){
            if(doctor.getClass() == doctorClass)
                return doctor;
        }
        return null;
    }
}

package Homework_lesson7;

import javax.print.Doc;

public class Patient extends Person{
    private Doctor doctor;
    private int treatmentPlan;
    private boolean isHealthy;

    {
        treatmentPlan = -1;
        isHealthy = false;
    }

    public Patient(String name){
        super(name);
    }
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    public Doctor getDoctor(){
        return this.doctor;
    }
    public void setTreatmentPlan(int plan){
        this.treatmentPlan = plan;
    }

    public int getPlan(){
        return this.treatmentPlan;
    }

    public void setHealthyStatus(boolean isHealthy){
        this.isHealthy = isHealthy;
    }

    public boolean isHealthy(){
        return this.isHealthy;
    }
}

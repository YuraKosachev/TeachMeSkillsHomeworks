package Homework_lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class University {
    private final String name;
    private List<Student> students;

    {
        this.students = new ArrayList<>();
    }

    public University(String name) {
        this.name = name;
    }

    public void enterRange(int course, Student... newStudents) {
        for (Student student : newStudents) {
            student.setCourse(course);
            this.students.add(student);
        }
    }

    public void enter(int course, Student newStudent) {

        newStudent.setCourse(course);
        this.students.add(newStudent);
    }

    public int studentsCount(){
        return this.students.size();
    }

    public void nextCourse(int course){
        setAvgScore();
        this.students = this.students.stream()
                .filter(student -> student.getAvgCourseScore() > 3 )
                .map(student -> {
                    student.setCourse(course);
                    return student;
                })
                .toList();
    }

    private void setAvgScore(){
        Random random = new Random();
        for(Student student : this.students){
            student.setAvgCourseScore(random.nextDouble(2,10));
        }
    }

    public List<Student> getStudentsByCourse(int course) {
        return this.students.stream()
                .filter(student -> student.getCourse() == course)
                .toList();
    }
}

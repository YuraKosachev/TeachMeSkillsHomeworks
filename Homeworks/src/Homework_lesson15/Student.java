package Homework_lesson15;

public class Student {
    private int course;
    private double avgCourseScore;
    private final String name;
    private final String group;

    public Student(String name, String group){
        this.name = name;
        this.group = group;
    }

    public void setAvgCourseScore(double avgCourseScore) {
        this.avgCourseScore = avgCourseScore;
    }

    public double getAvgCourseScore() {
        return avgCourseScore;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", avgCourseScore=" + avgCourseScore +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}

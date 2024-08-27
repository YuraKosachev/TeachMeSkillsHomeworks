package Homework_lesson9;

public class TestClone implements Cloneable {
    private String name;
    private String description;
    private double someValue;

    TestClone(String name, String description, double val) {
        this.description = description;
        this.name = name;
        this.someValue = val;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSomeValue(double someValue) {
        this.someValue = someValue;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Description: " + this.description + " Val: " + this.someValue;
    }

    public TestClone clone() throws CloneNotSupportedException {

        return (TestClone) super.clone();
    }
}

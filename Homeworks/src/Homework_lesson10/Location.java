package Homework_lesson10;

public class Location implements Cloneable {
    private String name;
    private String code;

    public Location(String name, String code){
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Location :"+ this.name +" Code:"+this.code + " Object ref->"+ super.toString();
    }

    @Override
    public Location clone() throws CloneNotSupportedException {
        return (Location)super.clone();
    }
}

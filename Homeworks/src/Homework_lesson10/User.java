package Homework_lesson10;

import java.util.Objects;
import java.util.UUID;

public class User implements Cloneable {
    private final UUID id;
    private String login;
    private String fullname;
    private final int age;
    private Location location;

    {
        this.id = UUID.randomUUID();
        this.location = new Location("Belarus", "BY");
    }

    public User(String login, String fullname, int age) {
        this.age = age;
        this.fullname = fullname;
        this.login = login;
    }

    public UUID getId() {
        return id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public void setLocationCode(String code){
        this.location.setCode(code);
    }

    public String getLocationString() {
        return location.toString();
    }

    @Override
    public String toString() {
        return "User: " + this.login + " Fullname: " + this.fullname + " Age: " + this.age + " Object ref ->:" + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.age, this.login, this.fullname, this.getClass());//super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public User deepCopy() throws CloneNotSupportedException {
        try {
            User userClone = this.clone();
            userClone.setLocation(this.location.clone());
            return userClone;
        } catch (CloneNotSupportedException ex) {
            throw new CloneNotSupportedException(ex.getMessage());
        }
    }
}

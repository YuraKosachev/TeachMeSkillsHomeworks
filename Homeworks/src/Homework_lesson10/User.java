package Homework_lesson10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public User deepClone() throws CloneNotSupportedException {
        try {
            User userClone = this.clone();

            Field[] fields = userClone.getClass().getDeclaredFields();

            for(Field field: fields){
                field.setAccessible(true);
                Object obj = field.get(userClone);
                if(obj instanceof  Cloneable){
                    Method method = obj.getClass().getMethod("clone");
                    if(method == null)
                        continue;
                    field.set(userClone, method.invoke(obj));
                }
            }
            return userClone;
        } catch (CloneNotSupportedException | IllegalAccessException ex) {
            throw new CloneNotSupportedException(ex.getMessage());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

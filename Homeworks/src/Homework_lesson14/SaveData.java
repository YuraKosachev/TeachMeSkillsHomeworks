package Homework_lesson14;

public class SaveData {
    private final String name;
    private final String data;

    public SaveData(String name, String data){
        this.data = data;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

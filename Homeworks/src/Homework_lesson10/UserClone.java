package Homework_lesson10;

import java.util.Random;
import java.util.UUID;

public class UserClone {
    private final User[] users;

    public UserClone(User... users) {
        this.users = users;
    }

    public String getUsersState(){
        StringBuilder builder = new StringBuilder();
        for(User user: this.users){
            builder.append("USER DATA -> " + user.toString() + " LOCATION -> "+ user.getLocationString()+"\n");
        }
        return builder.toString();
    }
    public UUID getRandomId(){
        if(this.users == null || this.users.length == 0)
        {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(0, this.users.length - 1);
        return this.users[index].getId();
    }
    public User getUser(UUID id) {
        for (User user : this.users)
            if (user.getId().equals(id))
                return user;

        return null;
    }

    public User copy(Copy copy, UUID id) {
        User user = getUser(id);

        if (user == null)
            return null;
        try {
            return Copy.Shallow == copy ? user.clone() : user.deepCopy();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}

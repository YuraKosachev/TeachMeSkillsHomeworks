package Homework_lesson10;

import java.util.UUID;

public class HomeWorkLesson10 {
    public static void main(String[] args) {
        //Task 1
        objectMethodsOverrideTask();

        //Task *
        deepShallowCopyTask();
    }

    private static void objectMethodsOverrideTask(){
        User user1 = new User("yuko", "Yury Kosachou", 38);
        User user2 = new User("yuko", "Yury Kosachou", 38);
        User user3 = new User("yuk", "Yury Kosachou", 38);

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
        System.out.println(user1.equals(user2));
        System.out.println(user2.equals(user3));
    }


    private static void deepShallowCopyTask(){
        User user1 = new User("karl", "Karl Marks", 65);
        User user2 = new User("lenin", "Vladimir Lenin", 40);
        User user3 = new User("stalin", "Josif Stalin", 50);

        UserClone userCloneFactory = new UserClone(user1, user2, user3);
        UUID randomId = userCloneFactory.getRandomId();

        System.out.println("SHALLOW COPY TEST-");
        User clone = userCloneFactory.copy(Copy.Shallow, randomId);
        User user = userCloneFactory.getUser(randomId);

        //Clone set a new login
        clone.setLogin("zuk");
        //Clone change location name
        //cloned and regular object refer to the same location object
        clone.setLocationCode("GE");

        System.out.println(clone);
        System.out.println(user);
        System.out.println("Location clone:"+clone.getLocationString());
        System.out.println("Location user:"+user.getLocationString());
        System.out.println(userCloneFactory.getUsersState());

        System.out.println("DEEP COPY TEST-");

        UUID deepRandomId = userCloneFactory.getRandomId();
        User deepClone = userCloneFactory.copy(Copy.Deep, deepRandomId);
        User deepUser = userCloneFactory.getUser(deepRandomId);

        //Clone set a new login
        deepClone.setLogin("zuk");
        //Clone change location name

        deepClone.setLocationCode("GE");

        System.out.println(deepClone);
        System.out.println(deepUser);
        System.out.println("Location clone:"+deepClone.getLocationString());
        System.out.println("Location user:"+deepUser.getLocationString());
        System.out.println(userCloneFactory.getUsersState());


    }
}

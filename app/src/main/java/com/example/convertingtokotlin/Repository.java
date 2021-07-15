package com.example.convertingtokotlin;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    // list of users
    private List<User> users = null;

    // singleton
    private static Repository INSTANCE = null;
    public static Repository getInstance() {

        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) INSTANCE = new Repository();
            }
        }
        return INSTANCE;
    }

    // keeping the constructor private to enforces the usage of getInstance
    private Repository() {

        // create some users
        User user1 = new User("Jane", "");
        User user2 = new User("John", null);
        User user3 = new User("Anne", "Doe");

        // create list of users
        users = new ArrayList();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getFormattedUserNames() {

        List<String> userNames = new ArrayList<>(users.size());

        for (User user : users) {

            String name;

            if (user.getLastName() != null) {

                if (user.getFirstName() != null) name = user.getFirstName() + " " + user.getLastName();
                else name = user.getLastName();
            }

            else if (user.getFirstName() != null) name = user.getFirstName();
            else name = "Unknown";

            userNames.add(name);
        }
        
        return userNames;
    }
}

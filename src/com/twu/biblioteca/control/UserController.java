package com.twu.biblioteca.control;


import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users = new ArrayList<User>();

    public void createUsers() {
        User user1 = new User("Gabi", "ga@gm.com", "111-2222", 90903030, 123456);
        User user2 = new User("Mike", "mike@aa.com", "111-1111", 30301234, 654321);
        User user3 = new User("a", "a", "1", 111, 1);

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public User findUser(String userLibraryNumber) {
        for (User user: users) {
            if (userLibraryNumber.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    public boolean verifyPassword(User user, int typedPassword) {
        return (user.getPassword() == typedPassword);
    }
}

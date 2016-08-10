package com.twu.biblioteca.control;

import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserControllerTest {
    private List<User> users = new ArrayList<User>();
    private UserController userController = new UserController();

    @Before
    public void setup() {
        userController.createUsers();
    }

    @Test
    public void givenLibraryNumberShouldFindUser() {
        User user1 = new User("Gabi", "ga@gm.com", "111-2222", 90903030, 123456);
        String libraryNumber = user1.getId();
        users.add(user1);

        assertNotNull(userController.findUser(libraryNumber));
    }
}
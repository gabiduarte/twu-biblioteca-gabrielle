package com.twu.biblioteca.control.commands;


import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.model.User;

public class SeeProfileCommand implements Command {
    User user;

    public SeeProfileCommand(User user) {
        this.user = user;
    }

    public void execute() {
        seeProfile();
    }
    
    public void seeProfile() {
        System.out.println(Message.VIEW_PROFILE);
        String userInformation = String.format(Message.PROFILE_FORMAT, user.getName(), user.getEmail(), user.getPhone());
        System.out.println(userInformation);
    }
}

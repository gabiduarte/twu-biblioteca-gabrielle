package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Option> options = new ArrayList<Option>();

    public void addOption(Option option) {
        if (options != null) {
            options.add(option);
        }
    }

    public ArrayList<Option> getOptionList() {
        return options;
    }
}

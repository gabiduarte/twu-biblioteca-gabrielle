package com.twu.biblioteca.control;

import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Option;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Option> options = new ArrayList<Option>();
    private OptionListener listener;

    public void addOption(Option option) {
        if (options != null) {
            options.add(option);
        }
    }

    public void showOptions() {

        if (options.size() > 0) {
            System.out.println("\n** Biblioteca Menu: Choose your option **");
            for (Option opt: options) {
                String optionId = Integer.toString(opt.getId());
                System.out.println(optionId + " - " + opt.getName());
            }
        } else {
            System.out.println("\n** Biblioteca Menu - No options available");
        }

    }

    public boolean getUserOption(int userOption) {
        int checkedUserOption = validateUserOption(userOption);

        if (checkedUserOption != 0 && listener != null) {
            listener.onOptionSelected(new Option(checkedUserOption));
            return true;
        } else {
            return false;
        }
    }

    public int validateUserOption(int userOption) {
        for (Option opt: options) {
            if (userOption == opt.getId()) {
                return opt.getId();
            }
        }
        return 0;
    }

    public void setListener(OptionListener listener) {
        this.listener = listener;
    }

    public ArrayList<Option> getOptionList() {
        return options;
    }
}

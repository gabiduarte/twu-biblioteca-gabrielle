package com.twu.biblioteca.control;

import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Option;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void getUserOption() {
        boolean userInputIsValid = false;
        while(!userInputIsValid) {
            try {
                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();

                for (Option opt: options) {
                    if (userInput == opt.getId()) {
                        userInputIsValid = (opt.getName().equals("Quit"));
                        Option option = new Option(userInput);

                        if (listener != null) {
                            listener.onOptionSelected(option);
                        }
                    }
                }
                if (!userInputIsValid) System.out.println("Wrong option, please choose again!");

            } catch (InputMismatchException exception) {
                System.out.println("Please insert a number");
            }
        }
    }

    public void setListener(OptionListener listener) {
        this.listener = listener;
    }

    public ArrayList<Option> getOptionList() {
        return options;
    }
}

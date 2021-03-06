package com.twu.biblioteca.control;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.model.Media;

import java.util.ArrayList;
import java.util.List;


public class Catalogue {

    public <T extends Media> List<T> retrieveSelectedList(List<T> list, boolean isAvailable) {
        List<T> selectedMovies = new ArrayList<T>();
        for (T media: list) {
            if (!media.isCheckedOut() == isAvailable) {
                selectedMovies.add(media);
            }
        }
        return (list.size() > 0) ? selectedMovies : null;
    }

    public <T extends Media> T selectMedia(List<T> list, int userOption) {

        for (T media: list) {
            if (userOption == media.getId()) {
                return media;
            }
        }
        return null;
    }

    public <T extends Media> String changeStatus(T media, boolean isCheckingOut, String typeOfMedia) {
        if (isCheckingOut) {
            if (!media.isCheckedOut()) {
                media.setCheckedOut(true);
                return String.format(Message.CHECKOUT_SUCCESSFUL, typeOfMedia);
            } else {
                return String.format(Message.CHECKOUT_UNSUCCESSFUL, typeOfMedia);
            }
        } else {
            if (media.isCheckedOut()) {
                media.setCheckedOut(false);
                return String.format(Message.RETURN_SUCCESSFUL, typeOfMedia);
            } else {
                return String.format(Message.RETURN_UNSUCCESSFUL, typeOfMedia);
            }
        }
    }
}
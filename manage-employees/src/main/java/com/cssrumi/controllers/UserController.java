package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.model.User;
import com.cssrumi.services.UserService;
import com.cssrumi.view.UserView;

import java.util.stream.Collectors;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = App.getUserService();
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void menu() {
        String choice = UserView.menu();
        switch (choice.toLowerCase()) {
            case "d":
                displayAll();
                break;
            default:
                break;
        }
    }

    private void displayAll() {
        UserView.displayAll(
                userService
                        .findAll()
                        .stream()
                        .map(User::getLogin)
                        .collect(Collectors.toSet())
        );
    }
}

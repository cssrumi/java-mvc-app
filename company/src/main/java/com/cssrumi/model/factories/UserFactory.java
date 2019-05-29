package com.cssrumi.model.factories;

import com.cssrumi.model.User;

public class UserFactory {
    public static User getUser(String login, String password) {
        return new User(login, password);
    }
}

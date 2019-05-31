package com.cssrumi.controllers;

import com.cssrumi.App;
import com.cssrumi.model.User;
import com.cssrumi.services.SessionService;
import com.cssrumi.services.UserService;
import com.cssrumi.view.SessionView;

import java.util.HashMap;

public class SessionController {

    private UserService userService;
    private SessionService sessionService;

    public SessionController() {
        this.userService = App.getUserService();
        this.sessionService = App.getSessionService();
    }

    public SessionController(UserService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;
    }

    public void authorize() {
        HashMap<String, String> user = SessionView.authorize();
        if(userService.login(user.get("login"), user.get("password"))) {
            sessionService.login();
            SessionView.authorized();
        } else {
            SessionView.unauthorized();
        }
    }
}

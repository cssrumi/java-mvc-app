package com.cssrumi.services;

public interface SessionService {
    void login();

    void logout();

    boolean isAuthorized();
}

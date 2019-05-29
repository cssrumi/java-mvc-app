package com.cssrumi.services;

public class SessionServiceImpl implements SessionService {

    private boolean isAuthorized;

    @Override
    public void login() {
        isAuthorized = true;
    }

    @Override
    public void logout() {
        isAuthorized = false;
    }

    @Override
    public boolean isAuthorized() {
        return isAuthorized;
    }
}

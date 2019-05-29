package com.cssrumi.services;

import com.cssrumi.model.User;

public interface UserService extends CrudService<User, Long> {

    boolean login(String login, String password);

    User findByLogin(String login);

}

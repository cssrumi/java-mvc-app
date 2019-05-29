package com.cssrumi.services.map;

import com.cssrumi.model.User;
import com.cssrumi.services.UserService;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class UserServiceMap extends AbstractMapService<User, Long> implements UserService {

    @Override
    public boolean login(String login, String password) {
        User user = findByLogin(login);
        if(user != null){
            return user.getPassword().equals(password);
        }
        return false;
    }

    @Override
    public Set<User> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(User object) {
        super.delete(object);
    }

    @Override
    public User save(User object) {
        return super.save(object);
    }

    @Override
    public User findById(Long id) {
        return super.findById(id);
    }

    @Override
    public User findByLogin(String login) {
        return map
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue().getLogin(), login))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}

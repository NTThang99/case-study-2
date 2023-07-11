package services;

import models.User;

import java.util.List;

public class UserSevice implements BasicCRUD<User> {
    @Override
    public User getByID(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void create(User obj) {

    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean isExist(int id) {
        return false;
    }
}

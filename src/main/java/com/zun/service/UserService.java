package com.zun.service;

import com.zun.domain.User;

import java.util.List;

public interface UserService {
    User insert(User user);

    List<User> getAll();

    User getById(int id);

    User getByName(String name);

    User update(int id, String nameUser);

    void deleteById(int id);
}

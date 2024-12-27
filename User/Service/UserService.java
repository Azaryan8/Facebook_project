package org.example.facebook_project.User.Service;

import org.example.facebook_project.User.Entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByName(String name);
    User create(User user);
    List<User> findAll();
}

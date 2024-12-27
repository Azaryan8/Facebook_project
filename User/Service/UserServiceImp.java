package org.example.facebook_project.User.Service;

import org.example.facebook_project.User.Entity.User;
import org.example.facebook_project.User.Repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService {
    private final userRepository repository;

    public UserServiceImp(userRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }



    @Override
    public User findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public User create(User user) {
        User existingUser = repository.findByName(user.getName());
        if (existingUser != null) {
            throw new RuntimeException("The User already exists");
        }

        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }



}

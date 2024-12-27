package org.example.facebook_project.User.Repository;

import org.example.facebook_project.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}

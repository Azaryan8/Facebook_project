package org.example.facebook_project.Image.Repository;

import org.example.facebook_project.Image.Entity.Image;
import org.example.facebook_project.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface imageRepository extends JpaRepository<Image, Long> {

    Image findByUser(User user);

}


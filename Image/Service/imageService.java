package org.example.facebook_project.Image.Service;

import org.example.facebook_project.Image.Entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface imageService {
    Optional<Image> getImageByID(Long id);
    Image getImageByURL(String url);

    Image changeImage(Long userId, MultipartFile file);
}


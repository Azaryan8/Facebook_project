package org.example.facebook_project.Image.Service;

import org.example.facebook_project.Image.Entity.Image;
import org.example.facebook_project.Image.Repository.imageRepository;
import org.example.facebook_project.User.Entity.User;
import org.example.facebook_project.User.Service.UserService;
import org.example.facebook_project.User.Service.UserServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service

public class imageServiceImp implements imageService {
    private final UserServiceImp userServiceImp ;
    private final imageRepository repository;
    private final FileStorageService fileStorageService;

    public imageServiceImp(imageRepository repository, FileStorageService fileStorageService, UserServiceImp userServiceImp) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
        this.userServiceImp = userServiceImp;
    }

    @Override
    public Optional<Image> getImageByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public Image getImageByURL(String url) {
        return null;
    }



    @Override
    public Image changeImage(Long userId, MultipartFile file) {
        User user = userServiceImp.findById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        String filePath;
        try {
            filePath = fileStorageService.saveFile(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
        Image image = repository.findByUser(user);
        if (image == null) {
            image = new Image();
            image.setUser(user);
        }
        image.setUrl(filePath);
        image.setSize((int) file.getSize());

        return repository.save(image);
    }

}

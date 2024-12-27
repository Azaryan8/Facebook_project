package org.example.facebook_project.Image.Controller;

import org.example.facebook_project.Image.Entity.Image;
import org.example.facebook_project.Image.Service.imageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class imageController {
    private final imageService service;

    public imageController(imageService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/image")
    public ResponseEntity<Image> uploadImage(@PathVariable Long userId, @RequestParam("file")MultipartFile file) {
        Image updatedImage = service.changeImage(userId, file);
        return ResponseEntity.ok(updatedImage);
    }

}

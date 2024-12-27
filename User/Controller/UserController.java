package org.example.facebook_project.User.Controller;

import org.example.facebook_project.Image.Entity.Image;
import org.example.facebook_project.Image.Service.imageService;
import org.example.facebook_project.User.Entity.User;
import org.example.facebook_project.User.Service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final imageService imgService;

    public UserController(UserService service, imageService imgService) {
        this.service = service;
        this.imgService = imgService;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public User getByName(@PathVariable String name){
        return service.findByName(name);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user){
        return service.create(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return service.findAll();
    }

    @PutMapping("/{id}/image")
    public Image uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        System.out.println("Received request to upload image for user " + id);
        return imgService.changeImage(id, file);
    }
}


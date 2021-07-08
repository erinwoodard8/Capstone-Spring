package com.tts.CapstoneApp.Controller;


import com.tts.CapstoneApp.Model.User;
import com.tts.CapstoneApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/post")
    public void addNewUser() {
        User newUser = new User("testUser", "test@gmail.com", "password");
        userRepository.save(newUser);
        System.out.println(newUser);
    }




}

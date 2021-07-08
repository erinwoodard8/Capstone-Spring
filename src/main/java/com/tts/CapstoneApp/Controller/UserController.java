package com.tts.CapstoneApp.Controller;


import com.tts.CapstoneApp.Model.User;
import com.tts.CapstoneApp.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/get")
    public User getUser(String email) {
        return userService.findByEmail(email);
    }


    @PostMapping("/post")
    public User addNewUser(@RequestBody User user) {
//        userService.saveUser(user);

        System.out.println(user);

        return userService.saveUser(user);

    }




}

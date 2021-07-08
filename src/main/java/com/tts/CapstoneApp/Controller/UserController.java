package com.tts.CapstoneApp.Controller;


import com.tts.CapstoneApp.Model.User;
import com.tts.CapstoneApp.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }

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

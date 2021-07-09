package com.tts.CapstoneApp.Service;

import com.tts.CapstoneApp.Model.User;

public interface UserService {

    public void processOAuthPostLogin(String id);

    public void deleteUser(Integer id);

    public User updateUser(User user);

    public User findByEmail(String email);

    public User saveUser(User user);

    public User getLoggedInUser();






}

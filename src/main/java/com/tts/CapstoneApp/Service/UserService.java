package com.tts.CapstoneApp.Service;

import com.tts.CapstoneApp.Model.User;

public interface UserService {

    public User addUser(User user);

    public void deleteUser(Integer id);

    public User updateUser(User user);

    public User findByEmail(String email);

    public void saveUser(User user);

    public User getLoggedInUser();





}
package com.tts.CapstoneApp.Service;

import com.tts.CapstoneApp.Model.CustomOAuth2User;
import com.tts.CapstoneApp.Model.User;
import com.tts.CapstoneApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends DefaultOAuth2UserService implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        return new CustomOAuth2User(user);
    }

    @Override
    public void processOAuthPostLogin(String id) {
        System.out.println("\n" + id);
        User existUser = userRepository.findUserById(id);
        System.out.println("\n" + existUser);

        if(existUser == null) {
            User newUser = new User();
            newUser.setId(id);
            System.out.println("\n" + "LoginUser: " + newUser);

            userRepository.save(newUser);
        }


    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getLoggedInUser() {
        return null;
    }
}

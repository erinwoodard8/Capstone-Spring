package com.tts.CapstoneApp.Configuration;

import com.tts.CapstoneApp.Repository.UserRepository;
import com.tts.CapstoneApp.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecruityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl oAuth2UserService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/console/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers("/users/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                // this will force oauth2 to use this loginpage for authentication
                .loginPage("/")
//                .loginProcessingUrl("/")
                .userInfoEndpoint()
                .userService(oAuth2UserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

                        //Casted using OAuth2User interface instead of CustomOAuth2User class
                        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
                        System.out.println(oAuth2User);

                        oAuth2UserService.processOAuthPostLogin(oAuth2User.getAttribute("sub"));

//                        response.sendRedirect("http://localhost3000");
                    }

        });


    }
}


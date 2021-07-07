package com.tts.CapstoneApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;


@Entity
    public class User {
        //FIELDS

        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        Integer id;

        String username;
        String email;
        String password;
        Long favoriteMovies[];

        //CONSTRUCTORS
        public User () {
        }

        public User (Integer id, String username, String email, String password, Long favoriteMovies[]) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.favoriteMovies = favoriteMovies;
        }
    //GETTERS

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long[] getFavoriteMovies() {
        return favoriteMovies;
    }

    //SETTERS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavoriteMovies(Long[] favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", favoriteMovies=" + Arrays.toString(favoriteMovies) +
                '}';
    }
}


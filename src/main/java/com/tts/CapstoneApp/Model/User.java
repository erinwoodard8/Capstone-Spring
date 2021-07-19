package com.tts.CapstoneApp.Model;


import javax.persistence.*;
import java.util.Arrays;


@Entity
@Table(name="Users")
    public class User {
        //FIELDS

        @Id
        String id;
        String username;
        String email;
        String favoriteMovies[];

        //CONSTRUCTORS
        public User () {
        }

        public User (String username, String email) {
            this.username = username;
            this.email = email;
        }
    //GETTERS

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String[] getFavoriteMovies() {
        return favoriteMovies;
    }

    //SETTERS

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoriteMovies(String[] favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", favoriteMovies=" + Arrays.toString(favoriteMovies) +
                '}';
    }
}



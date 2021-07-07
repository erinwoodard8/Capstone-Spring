package com.tts.CapstoneApp.Repository;

import com.tts.CapstoneApp.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Double> {

}

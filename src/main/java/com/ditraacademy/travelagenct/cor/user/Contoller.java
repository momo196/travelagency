package com.ditraacademy.travelagenct.cor.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Contoller {


    @Autowired
    UserServices userServices;

    @PostMapping ("/user")
    public  ResponseEntity<?> createUser(@RequestBody User user) {

        return userServices.createUserService(user);
    }
    @GetMapping("/user")
    public List<User> getAllUsers() {

        return userServices.getAllUsers();

    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {

        return userServices.getUser(id);

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id ) {

            return userServices.deleteUser(id);

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?>  updateUser(@PathVariable int id,@RequestBody User updatedUser) {

        return userServices.updateUser(id,updatedUser);

    }

}

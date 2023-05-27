package com.manjusha.wastemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manjusha.wastemanagement.entities.User;
import com.manjusha.wastemanagement.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
        return new ResponseEntity<>(this.userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.userService.getAll(),
                HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        User exists = this.userService.getById(id);
        if (exists != null)
            return new ResponseEntity<>(exists, HttpStatus.OK);
        else
            return new ResponseEntity<>("User of this id does not exists",
                    HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        User exists = this.userService.getById(id);
        if (exists != null) {
            this.userService.deleteUser(id);
            return new ResponseEntity<>("User Deleted", HttpStatus.OK);
        } else
            return new ResponseEntity<>("User of this id does not exists",
                    HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,
                                @RequestBody @Valid User user){
        User exists = this. userService.getById(id);
        if(exists != null){
            return new ResponseEntity<>(this.userService.updateUser(id, user), 
                HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("User of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

}

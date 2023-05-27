package com.manjusha.wastemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjusha.wastemanagement.entities.User;
import com.manjusha.wastemanagement.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    //Create 
    public User addUser(User user){
        return this.userRepository.save(user);
    }

    //Read All Records
    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    //Read One Record
    public User getById(Integer id){
        return this.userRepository.findById(id).orElse(null);
    }

    //Delete 
    public void deleteUser(Integer id){
        this.userRepository.deleteById(id);
    }

    //Update
    public User updateUser(Integer id, User user){
        user.setId(id);
        return this.userRepository.save(user);
    }
}


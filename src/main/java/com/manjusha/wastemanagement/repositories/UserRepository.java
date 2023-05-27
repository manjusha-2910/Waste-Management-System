package com.manjusha.wastemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjusha.wastemanagement.entities.User;

@Repository
public interface UserRepository 
    extends JpaRepository<User, Integer>{
    
}


package com.manjusha.wastemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjusha.wastemanagement.entities.Waste;

@Repository
public interface WasteRepository 
    extends JpaRepository<Waste, Integer>{
    
}


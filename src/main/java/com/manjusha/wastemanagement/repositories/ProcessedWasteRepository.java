package com.manjusha.wastemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjusha.wastemanagement.entities.ProcessedWaste;

@Repository
public interface ProcessedWasteRepository 
    extends JpaRepository<ProcessedWaste, Integer>{
    
}


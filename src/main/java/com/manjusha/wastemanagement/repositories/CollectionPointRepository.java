package com.manjusha.wastemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjusha.wastemanagement.entities.CollectionPoint;

@Repository
public interface CollectionPointRepository 
    extends JpaRepository<CollectionPoint, Integer>{
    
}


package com.manjusha.wastemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjusha.wastemanagement.entities.Recycler;

@Repository
public interface RecyclerRepository 
    extends JpaRepository<Recycler, Integer>{
    
}


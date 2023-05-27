package com.manjusha.wastemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjusha.wastemanagement.entities.Waste;
import com.manjusha.wastemanagement.repositories.WasteRepository;

@Service
public class WasteService {
    
    @Autowired
    private WasteRepository wasteRepository;

    //Create 
    public Waste addWaste (Waste waste){
        return this.wasteRepository.save(waste);
    }

    //Read All Records
    public List<Waste> getAll(){
        return this.wasteRepository.findAll();
    }

    //Read One Record
    public Waste getById(Integer id){
        return this.wasteRepository.findById(id).orElse(null);
    }

    //Delete 
    public void deleteWaste(Integer id){
        this.wasteRepository.deleteById(id);
    }

    //Update
    public Waste updateWaste(Integer id, Waste waste){
        waste.setId(id);
        return this.wasteRepository.save(waste);
    }
}


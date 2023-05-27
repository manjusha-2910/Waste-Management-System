package com.manjusha.wastemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjusha.wastemanagement.entities.ProcessedWaste;
import com.manjusha.wastemanagement.repositories.ProcessedWasteRepository;

@Service
public class ProcessedWasteService {
    
    @Autowired
    private ProcessedWasteRepository processedWasteRepository;

    //Create 
    public ProcessedWaste addProcessedWaste(ProcessedWaste processedWaste){
        return this.processedWasteRepository.save(processedWaste);
    }

    //Read All Records
    public List<ProcessedWaste> getAll(){
        return this.processedWasteRepository.findAll();
    }

    //Read One Record
    public ProcessedWaste getById(Integer id){
        return this.processedWasteRepository.findById(id).orElse(null);
    }

    //Delete 
    public void deleteProcessedWaste(Integer id){
        this.processedWasteRepository.deleteById(id);
    }

    //Update
    public ProcessedWaste updateProcessedWaste(Integer id, ProcessedWaste processedWaste){
        processedWaste.setId(id);
        return this.processedWasteRepository.save(processedWaste);
    }
}


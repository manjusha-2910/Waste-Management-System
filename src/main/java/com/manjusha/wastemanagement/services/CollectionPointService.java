package com.manjusha.wastemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjusha.wastemanagement.entities.CollectionPoint;
import com.manjusha.wastemanagement.repositories.CollectionPointRepository;

@Service
public class CollectionPointService {
    
    @Autowired
    private CollectionPointRepository collectionPointRepository;

    //Create 
    public CollectionPoint addCollectionPoint (CollectionPoint collectionPoint){
        return this.collectionPointRepository.save(collectionPoint);
    }

    //Read All Records
    public List<CollectionPoint> getAll(){
        return this.collectionPointRepository.findAll();
    }

    //Read One Record
    public CollectionPoint getById(Integer id){
        return this.collectionPointRepository.findById(id).orElse(null);
    }

    //Delete 
    public void deleteCollectionPoint (Integer id){
        this.collectionPointRepository.deleteById(id);
    }

    //Update
    public CollectionPoint updateCollectionPoint (Integer id, CollectionPoint collectionPoint){
        collectionPoint.setId(id);
        return this.collectionPointRepository.save(collectionPoint);
    }
}


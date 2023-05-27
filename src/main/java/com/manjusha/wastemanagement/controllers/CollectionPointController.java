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

import com.manjusha.wastemanagement.entities.CollectionPoint;
import com.manjusha.wastemanagement.services.CollectionPointService;

import jakarta.validation.Valid;

@Controller
public class CollectionPointController {

    @Autowired
    private CollectionPointService collectionPointService;

    @PostMapping("/collectionPoints")
    public ResponseEntity<?> addCollectionPoint (@RequestBody @Valid CollectionPoint collectionPoint){
        return new ResponseEntity<>(this.collectionPointService.addCollectionPoint (collectionPoint)
        , HttpStatus.CREATED);
    }

    @GetMapping("/collectionPoints")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this. collectionPointService.getAll(),
            HttpStatus.OK);
    }

    @GetMapping("/collectionPoints/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        CollectionPoint exists = this.collectionPointService.getById(id);
        if(exists != null)
            return new ResponseEntity<>(exists, HttpStatus.OK);
        else
            return new ResponseEntity<>("CollectionPoint of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/collectionPoints/{id}")
    public ResponseEntity<?> deleteCollectionPoint(@PathVariable Integer id){
        CollectionPoint exists = this.collectionPointService.getById(id);
        if(exists != null){
            this.collectionPointService.deleteCollectionPoint(id);
            return new ResponseEntity<>("CollectionPoint Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("CollectionPoint of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/collectionPoints/{id}")
    public ResponseEntity<?> updateCollectionPoint(@PathVariable Integer id,
                                @RequestBody @Valid CollectionPoint collectionPoint){
        CollectionPoint exists = this.collectionPointService.getById(id);
        if(exists != null){
            return new ResponseEntity<>(this.collectionPointService.updateCollectionPoint(id, collectionPoint), 
                HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("CollectionPoint of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }
}


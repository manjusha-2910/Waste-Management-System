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

import com.manjusha.wastemanagement.entities.Recycler;
import com.manjusha.wastemanagement.services.RecyclerService;

import jakarta.validation.Valid;

@Controller
public class RecyclerController {

    @Autowired
    private RecyclerService recyclerService;

    @PostMapping("/recyclers")
    public ResponseEntity<?> addRecycler(@RequestBody @Valid Recycler recycler){
        return new ResponseEntity<>(this.recyclerService.addRecycler(recycler)
        , HttpStatus.CREATED);
    }

    @GetMapping("/recyclers")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.recyclerService.getAll(),
            HttpStatus.OK);
    }

    @GetMapping("/recyclers/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Recycler exists = this.recyclerService.getById(id);
        if(exists != null)
            return new ResponseEntity<>(exists, HttpStatus.OK);
        else
            return new ResponseEntity<>("Recycler of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/recyclers/{id}")
    public ResponseEntity<?> deleteRecycler(@PathVariable Integer id){
        Recycler exists = this.recyclerService.getById(id);
        if(exists != null){
            this.recyclerService.deleteRecycler(id);
            return new ResponseEntity<>("Recycler Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Recycler of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/recyclers/{id}")
    public ResponseEntity<?> updateRecycler(@PathVariable Integer id,
                                @RequestBody @Valid Recycler recycler){
        Recycler exists = this.recyclerService.getById(id);
        if(exists != null){
            return new ResponseEntity<>(this.recyclerService.updateRecycler(id, recycler), 
                HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Recycler of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

}


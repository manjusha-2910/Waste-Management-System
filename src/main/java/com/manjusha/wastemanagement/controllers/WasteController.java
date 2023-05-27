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

import com.manjusha.wastemanagement.entities.Waste;
import com.manjusha.wastemanagement.services.WasteService;

import jakarta.validation.Valid;

@Controller
public class WasteController {

    @Autowired
    private WasteService wasteService;

    @PostMapping("/wastes")
    public ResponseEntity<?> addWaste(@RequestBody @Valid Waste waste){
        return new ResponseEntity<>(this.wasteService.addWaste(waste)
        , HttpStatus.CREATED);
    }

    @GetMapping("/wastes")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.wasteService.getAll(),
            HttpStatus.OK);
    }

    @GetMapping("/wastes/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Waste exists = this.wasteService.getById(id);
        if(exists != null)
            return new ResponseEntity<>(exists, HttpStatus.OK);
        else
            return new ResponseEntity<>("Waste of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/wastes/{id}")
    public ResponseEntity<?> deleteWaste(@PathVariable Integer id){
        Waste exists = this.wasteService.getById(id);
        if(exists != null){
            this.wasteService.deleteWaste(id);
            return new ResponseEntity<>("Waste Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Waste of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/wastes/{id}")
    public ResponseEntity<?> updateWaste(@PathVariable Integer id,
                                @RequestBody @Valid Waste waste){
        Waste exists = this.wasteService.getById(id);
        if(exists != null){
            return new ResponseEntity<>(this.wasteService.updateWaste(id, waste), 
                HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Waste of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

}


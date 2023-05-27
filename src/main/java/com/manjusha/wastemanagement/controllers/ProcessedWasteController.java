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

import com.manjusha.wastemanagement.entities.ProcessedWaste;
import com.manjusha.wastemanagement.services.ProcessedWasteService;

import jakarta.validation.Valid;

@Controller
public class ProcessedWasteController {

    @Autowired
    private ProcessedWasteService processedWasteService;

    @PostMapping("/processedWastes")
    public ResponseEntity<?> addProcessedWaste(@RequestBody @Valid ProcessedWaste processedWaste) {
        return new ResponseEntity<>(this.processedWasteService.addProcessedWaste(processedWaste), HttpStatus.CREATED);
    }

    @GetMapping("/processedWastes")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.processedWasteService.getAll(),
                HttpStatus.OK);
    }

    @GetMapping("/processedWastes/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        ProcessedWaste exists = this.processedWasteService.getById(id);
        if (exists != null)
            return new ResponseEntity<>(exists, HttpStatus.OK);
        else
            return new ResponseEntity<>("ProcessedWaste of this id does not exists",
                    HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/processedWastes/{id}")
    public ResponseEntity<?> deleteProcessedWaste(@PathVariable Integer id) {
        ProcessedWaste exists = this.processedWasteService.getById(id);
        if (exists != null) {
            this.processedWasteService.deleteProcessedWaste(id);
            return new ResponseEntity<>("ProcessedWaste Deleted", HttpStatus.OK);
        } else
            return new ResponseEntity<>("ProcessedWaste of this id does not exists",
                    HttpStatus.NOT_FOUND);
    }

    @PutMapping("/processedWastes/{id}")
    public ResponseEntity<?> updateProcessedWaste(@PathVariable Integer id,
            @RequestBody @Valid ProcessedWaste processedWaste) {
        ProcessedWaste exists = this.processedWasteService.getById(id);
        if (exists != null) {
            return new ResponseEntity<>(this.processedWasteService.updateProcessedWaste(id, processedWaste),
                    HttpStatus.OK);
        } else
            return new ResponseEntity<>("ProcessedWaste of this id does not exists",
                    HttpStatus.NOT_FOUND);
    }
}

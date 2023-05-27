package com.manjusha.wastemanagement.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class ProcessedWaste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "quantity cannot be null")
    private double quantity;

    @NotNull(message = "processinDate cannot be null")
    private LocalDate processingDate;

    //Many processed waste materials can be associated with a single recycler
    @ManyToOne
    @JoinColumn(name = "recycler_id")
    private Recycler recycler;

    //Many processed waste materials can be derived from a single waste material
    @ManyToOne
    @JoinColumn(name = "waste_id")
    private Waste waste;

}


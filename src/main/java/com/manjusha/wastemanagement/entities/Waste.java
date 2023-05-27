package com.manjusha.wastemanagement.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Waste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "type cannot be null")
    @NotEmpty(message = "type cannot be empty")
    private String type;

    @NotNull(message = "quantity cannot be null")
    private double quantity;

    @NotNull(message = "collectionDate cannot be null")
    private LocalDate collectionDate;


    //Many wastes can belong to a single collection point.
    @ManyToOne
    @JoinColumn(name = "collection_point_id")
    private CollectionPoint collectionPoint;

    //A waste material can derive many processed waste.
    @OneToMany(mappedBy = "waste")
    private List<ProcessedWaste> processedWastes;
}


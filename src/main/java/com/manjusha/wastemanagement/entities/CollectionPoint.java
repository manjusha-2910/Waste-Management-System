package com.manjusha.wastemanagement.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class CollectionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "location cannot be null")
    @NotEmpty(message = "location cannot be empty")
    private String location;

    @NotNull(message = "mobile number cannot be null")
    @NotEmpty(message = "mobile number cannot be empty")
    private String mobile;

    // One collection point can have multiple waste materials.
    @OneToMany(mappedBy = "collectionPoint")
    private List<Waste> wastes;

    //a collection point can have multiple users
    @ManyToMany(mappedBy = "collectionPoints")
    private List<User> users;

}

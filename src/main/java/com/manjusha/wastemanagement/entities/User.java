package com.manjusha.wastemanagement.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "tblUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;

    @NotNull(message = "password cannot be null")
    @NotEmpty(message = "password cannot be empty")
    @Size(min = 6, message = "password shoud have minimum 6 character")
    @Column(unique = true)
    private String password;

    @NotNull(message = "mobile number cannot be null")
    @NotEmpty(message = "mobile number cannot be empty")
    private String mobile;


    //A user can be associated with multiple collection points
    @ManyToMany
    @JoinTable(
        name = "user_collection_points",
        joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "collection_point_id",referencedColumnName = "id")
    )
    private List<CollectionPoint> collectionPoints;


    //a user can be associated with multiple recyclers
    @ManyToMany
    @JoinTable(
        name = "user_recyclers",
        joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "recycler_id",referencedColumnName = "id")
    )
    private List<Recycler> recyclers;


}


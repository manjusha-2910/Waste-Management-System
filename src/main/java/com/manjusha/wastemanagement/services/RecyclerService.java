package com.manjusha.wastemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjusha.wastemanagement.entities.Recycler;
import com.manjusha.wastemanagement.repositories.RecyclerRepository;

@Service
public class RecyclerService {
    
    @Autowired
    private RecyclerRepository recyclerRepository;

    //Create 
    public Recycler addRecycler(Recycler recycler){
        return this.recyclerRepository.save(recycler);
    }

    //Read All Records
    public List<Recycler> getAll(){
        return this.recyclerRepository.findAll();
    }

    //Read One Record
    public Recycler getById(Integer id){
        return this.recyclerRepository.findById(id).orElse(null);
    }

    //Delete 
    public void deleteRecycler (Integer id){
        this.recyclerRepository.deleteById(id);
    }

    //Update
    public Recycler updateRecycler (Integer id, Recycler recycler){
        recycler.setId(id);
        return this.recyclerRepository.save(recycler);
    }
}


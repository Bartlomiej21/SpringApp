package com.home.my_projects.spring1.MySpring.api;

import com.home.my_projects.spring1.MySpring.dao.BikeDAO;
import com.home.my_projects.spring1.MySpring.model.Bike;
import com.home.my_projects.spring1.MySpring.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequestMapping("api/v2/bike")
@RestController
public class ServiceController {
    private final BikeService bikeService;

    @Autowired
    ServiceController(BikeService bikeService){
        this.bikeService = bikeService;
    }

    @PostMapping
    void addBikeToDatabase(Bike bike){
        bikeService.addBikeToDatabase(bike);
    }

    @GetMapping
    public Optional<Bike> selectBike(String name){
        return bikeService.selectBike(name);
    }

    @GetMapping
    public List<Bike> selectAllBikes(){return bikeService.selectAllBikes();}

    @DeleteMapping
    public int deleteBikeByName(String name){
        return bikeService.deleteBikeByName(name);
    }

    @PutMapping
    public int updateBikeInfoByName(String name, Bike bike){
        return 1;  //dokończyć
    }
}

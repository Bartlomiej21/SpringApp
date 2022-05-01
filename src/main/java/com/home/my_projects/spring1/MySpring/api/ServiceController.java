package com.home.my_projects.spring1.MySpring.api;

import com.home.my_projects.spring1.MySpring.model.Bike;
import com.home.my_projects.spring1.MySpring.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@RequestMapping("api/v2/bike")
@RestController
public class ServiceController {
    private final BikeService bikeService;

    @Autowired
    ServiceController(BikeService bikeService){
        this.bikeService = bikeService;
    }

    @PostMapping
    void addBikeToDatabase(@Valid @NotNull @RequestBody Bike bike){
        bikeService.addBikeToDatabase(bike);
    }

    @GetMapping(path = "{name}")
    public Bike selectBike(@PathVariable("name") String name){
        return bikeService.selectBike(name).orElse(null);
    }

    @GetMapping
    public List<Bike> selectAllBikes(){return bikeService.selectAllBikes();}

    @DeleteMapping(path = "{name}")
    public int deleteBikeByName(@PathVariable("name") String name){
        return bikeService.deleteBikeByName(name);
    }

    @PutMapping(path = "{name}")
    public int updateBikeInfoByName(@PathVariable("name") String name,
                                    @Valid @NotNull @RequestBody Bike bike){
        return bikeService.updateBikeInfoByName(name,bike);
    }
}

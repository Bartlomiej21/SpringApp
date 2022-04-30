package com.home.my_projects.spring1.MySpring.dao;

import com.home.my_projects.spring1.MySpring.model.Bike;

import java.util.List;
import java.util.Optional;
import java.util.Random;
public interface BikeDAO {

    int addBikeToDatabase(int maxSpeed, Bike bike);

    default int addBikeToDatabase(Bike bike){
        Random rand = new Random();
        return addBikeToDatabase(10+rand.nextInt(50),bike);
    }

    Optional<Bike> selectBike(String name);

    List<Bike> selectAllBikes();

    int deleteBikeByName(String name);

    int updateBikeInfoByName(String name, Bike bike);
}

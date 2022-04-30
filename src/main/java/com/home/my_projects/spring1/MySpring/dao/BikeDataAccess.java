package com.home.my_projects.spring1.MySpring.dao;

import com.home.my_projects.spring1.MySpring.model.Bike;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("myOwnDatabase")
public class BikeDataAccess implements BikeDAO {

    private static List<Bike> database = new ArrayList<>();

    @Override
    public int addBikeToDatabase(int maxSpeed, Bike newBike) {
        database.add(new Bike(maxSpeed,newBike.getName()));
        return 1;
    }

    @Override
    public Optional<Bike> selectBike(String name) {
        return database.stream().filter(x -> x.getName().equals(name)).findFirst();
    }

    @Override
    public List<Bike> selectAllBikes() {
        return database;
    }

    @Override
    public int deleteBikeByName(String name) {
        Optional<Bike> tempBike = selectBike(name);
        if (tempBike.isEmpty()){
            return 0;
        } else {
            database.remove(tempBike.get());   //remember, it's object.get(), not just Object
            return 1;
        }
    }

    @Override
    public int updateBikeInfoByName(String name, Bike updateBike) {
        return selectBike(name)
                .map(bike -> {
                int indexOfBikeToUpdate = database.indexOf(bike);
                if (indexOfBikeToUpdate>=0){
                    database.set(indexOfBikeToUpdate,new Bike(updateBike.getMaxSpeed(),name));
                    return 1;
                }
                return 0;
                }).
                orElse(0);
    }
}

package com.home.my_projects.spring1.MySpring.service;

import com.home.my_projects.spring1.MySpring.dao.BikeDAO;
import com.home.my_projects.spring1.MySpring.model.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    private final BikeDAO bikeDao;

    @Autowired
    public BikeService(@Qualifier("myQualifier") BikeDAO bikeDao){
        this.bikeDao = bikeDao;
    }

    public int addBikeToDatabase(Bike bike){
        return bikeDao.addBikeToDatabase(bike);
    }

    public Optional<Bike> selectBike(String name){
        return bikeDao.selectBike(name);
    }

    public List<Bike> selectAllBikes(){
        return bikeDao.selectAllBikes();
    }

    public int deleteBikeByName(String name){
        return bikeDao.deleteBikeByName(name);
    }

    public int updateBikeInfoByName(String name, Bike bike){
        return bikeDao.updateBikeInfoByName(name,bike);
    }
}

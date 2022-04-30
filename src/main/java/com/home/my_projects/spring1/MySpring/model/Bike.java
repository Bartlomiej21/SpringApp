package com.home.my_projects.spring1.MySpring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Bike {
    private final int wheelNumber = 2;
    private final int maxSpeed;
    @NotBlank
    private final String name;

    public Bike(@JsonProperty("speed") int speed, @JsonProperty("name") String name){
        this.maxSpeed = speed;
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getName() {
        return name;
    }
}

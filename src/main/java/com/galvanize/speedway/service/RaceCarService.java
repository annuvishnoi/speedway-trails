package com.galvanize.speedway.service;

import com.galvanize.speedway.entities.Car;
import com.galvanize.speedway.repository.RaceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceCarService {

    @Autowired
    private RaceCarRepository raceCarRepository;

    public Car addCar(Car car) {
        return raceCarRepository.save(car);
    }

}

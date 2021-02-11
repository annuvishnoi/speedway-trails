package com.galvanize.speedway.service;

import com.galvanize.speedway.entities.Car;
import com.galvanize.speedway.entities.Owner;
import com.galvanize.speedway.repository.OwnerRepository;
import com.galvanize.speedway.repository.RaceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceCarService {

    @Autowired
    private RaceCarRepository raceCarRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public Car addCar(Car car) {
        Owner owner = ownerRepository.findById(car.getOwnerId()).get();
        car.setOwner(owner);
        return raceCarRepository.save(car);
    }

    public List<Car> getAllCars() {
        return this.raceCarRepository.findAll();
    }
}

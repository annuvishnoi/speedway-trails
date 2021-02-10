package com.galvanize.speedway.controller;

import com.galvanize.speedway.entities.Car;
import com.galvanize.speedway.response.SpeedWayResponse;
import com.galvanize.speedway.service.RaceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceCarController {

    @Autowired
    private RaceCarService raceCarService;

    @PostMapping("/api/v1/racecars")
    @ResponseStatus(HttpStatus.CREATED)
    public SpeedWayResponse addCar(@RequestBody Car car){
        Car carCreated = raceCarService.addCar(car);
        SpeedWayResponse speedWayResponse = SpeedWayResponse.builder()
                .status("CREATED")
                .status_code(HttpStatus.CREATED.value())
                .data(carCreated).build();
        return speedWayResponse;
    }
}

package com.galvanize.speedway.controller;

import com.galvanize.speedway.entities.Car;
import com.galvanize.speedway.response.SpeedWayResponse;
import com.galvanize.speedway.service.RaceCarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Speedway-trails" )
@RequestMapping("/api/v1/racecars")
public class RaceCarController {

    @Autowired
    private RaceCarService raceCarService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpeedWayResponse addCar(@RequestBody Car car){
        Car carCreated = raceCarService.addCar(car);
        SpeedWayResponse speedWayResponse = SpeedWayResponse.builder()
                .status("CREATED")
                .status_code(HttpStatus.CREATED.value())
                .data(carCreated).build();
        return speedWayResponse;
    }

    @GetMapping
    public SpeedWayResponse getAllCars(){
        List<Car> cars = raceCarService.getAllCars();
        SpeedWayResponse speedWayResponse = SpeedWayResponse.builder()
                .status("OK")
                .status_code(HttpStatus.OK.value())
                .data(cars).build();
        return speedWayResponse;
    }

}

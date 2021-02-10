package com.galvanize.speedway.repository;

import com.galvanize.speedway.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceCarRepository extends JpaRepository<Car, Long> {

}

package com.galvanize.speedway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.speedway.entities.Car;
import com.galvanize.speedway.entities.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RaceCarControllerITTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    /*{
    "status": "OK",
    "status_code": 200,
    "data": [
        {
            "id": 43,
            "nickname": "The Condor",
            "model": "Corvette",
            "year": "2019",
            "owner": {...},
            "status": "AVAILABLE",
            "top_speed": 189
        }
    ]
}*/

    @Test
    public void test_addNewCar() throws Exception {

        Car car = Car.builder().nickName("The Condor").model("Corvette").year("2019").ownerId(1L).status("AVAILABLE").topSpeed(189).build();


        mvc.perform(MockMvcRequestBuilders.post("/api/v1/racecars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(car)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("CREATED"))
                .andExpect(jsonPath("$.status_code").value(201))
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.nickName").value(car.getNickName()))
                .andExpect(jsonPath("$.data.model").value(car.getModel()))
                .andExpect(jsonPath("$.data.year").value(car.getYear()))
                .andExpect(jsonPath("$.data.ownerId").value(car.getOwnerId()))
                .andExpect(jsonPath("$.data.status").value(car.getStatus()))
                .andExpect(jsonPath("$.data.topSpeed").value(car.getTopSpeed()));
    }

    @Test
    public void test_getAllCars() throws Exception {

        Car car = Car.builder().nickName("The Condor").model("Corvette").year("2019").ownerId(27L).status("AVAILABLE").topSpeed(120).build();


        mvc.perform(MockMvcRequestBuilders.get("/api/v1/racecars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.status_code").value(200))
                .andExpect(jsonPath("$.data[0].id").exists())
                .andExpect(jsonPath("$.data[0].nickName").value(car.getNickName()))
                .andExpect(jsonPath("$.data[0].model").value(car.getModel()))
                .andExpect(jsonPath("$.data[0].year").value(car.getYear()))
                .andExpect(jsonPath("$.data[0].owner.firstName").value("Maria"))
                .andExpect(jsonPath("$.data[0].status").value(car.getStatus()))
                .andExpect(jsonPath("$.data[0].topSpeed").value(car.getTopSpeed()));
    }
}

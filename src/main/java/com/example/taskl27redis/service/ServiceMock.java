package com.example.taskl27redis.service;

import com.example.taskl27redis.model.response.CarResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class ServiceMock implements CarService {


    @Override
    public CarResponse getCar(Long id) {
        return CarResponse.builder()
                .id(1L)
                .brand("Audi")
                .model("A4")
                .year(2002)
                .fuelType("Diesel")
                .build();
    }

}

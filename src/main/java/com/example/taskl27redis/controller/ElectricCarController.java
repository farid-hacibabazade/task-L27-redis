package com.example.taskl27redis.controller;


import com.example.taskl27redis.model.response.CarResponse;
import com.example.taskl27redis.service.CarService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/cars/ev")
public class ElectricCarController {
    private final CarService carService;

    public ElectricCarController(@Qualifier("electricCarServiceHandler") CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public CarResponse getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

}

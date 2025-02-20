package com.example.taskl27redis.controller;


import com.example.taskl27redis.model.response.CarResponse;
import com.example.taskl27redis.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(@Qualifier("carServiceHandler") CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public CarResponse getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

}

package com.example.taskl27redis.service;


import com.example.taskl27redis.dao.entity.CarEntity;
import com.example.taskl27redis.dao.repository.CarRepository;
import com.example.taskl27redis.model.enums.CarStatus;
import com.example.taskl27redis.model.response.CarResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class ElectricCarServiceHandler implements CarService {
    private final CarRepository carRepository;


    @Override
    public CarResponse getCar(Long id) {
        var car = fetchCarIfExits(id);
        return CarResponse.builder()
                .brand("Tesla")
                .model("S")
                .year(2020)
                .fuelType("EV")
                .build();
    }


    private CarEntity fetchCarIfExits(Long id) {
        return carRepository.findByIdAndStatusNot(id, CarStatus.SOLD)
                .orElseThrow(RuntimeException::new);
    }
}

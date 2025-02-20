package com.example.taskl27redis.service;


import com.example.taskl27redis.dao.entity.CarEntity;
import com.example.taskl27redis.dao.repository.CarRepository;
import com.example.taskl27redis.model.enums.CarStatus;
import com.example.taskl27redis.model.response.CarResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static com.example.taskl27redis.mapper.CarMapper.mapEntityToResponse;


@Slf4j
@Service
@RequiredArgsConstructor
@Profile("!test")
//@Primary
public class CarServiceHandler implements CarService {
    private final CarRepository carRepository;


    @Override
    public CarResponse getCar(Long id) {
        var car = fetchCarIfExits(id);
        return mapEntityToResponse(car);
    }


    private CarEntity fetchCarIfExits(Long id) {
        return carRepository.findByIdAndStatusNot(id, CarStatus.SOLD)
                .orElseThrow(RuntimeException::new);
    }
}

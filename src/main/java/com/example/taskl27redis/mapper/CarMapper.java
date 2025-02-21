package com.example.taskl27redis.mapper;


import com.example.taskl27redis.dao.entity.CarEntity;
import com.example.taskl27redis.model.enums.CarStatus;
import com.example.taskl27redis.model.request.CreateCarRequest;
import com.example.taskl27redis.model.response.CarResponse;

public class CarMapper {

    public static CarResponse mapEntityToResponse(CarEntity car) {
        return new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getFuelType(),
                car.getPrice()
        );
    }

    public static CarEntity mapRequestToEntity(CreateCarRequest car) {
        return CarEntity.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .fuelType(car.getFuelType())
                .price(car.getPrice())
                .status(CarStatus.ACTIVE)
                .build();
    }
}

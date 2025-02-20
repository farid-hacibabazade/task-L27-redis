package com.example.taskl27redis.mapper;

import com.example.taskl27redis.dao.entity.CarEntity;
import com.example.taskl27redis.model.cache.CarCacheDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum EntityToCacheMapper {
    CACHE_MAPPER;

    public CarCacheDto mapEntityToCacheDto(CarEntity carEntity){
        return CarCacheDto.builder()
                .id(carEntity.getId())
                .brand(carEntity.getBrand())
                .model(carEntity.getModel())
                .price(carEntity.getPrice())
                .build();
    }
}

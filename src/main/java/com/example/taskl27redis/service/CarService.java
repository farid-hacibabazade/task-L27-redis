package com.example.taskl27redis.service;


import com.example.taskl27redis.dao.entity.CarEntity;
import com.example.taskl27redis.dao.repository.CarRepository;
import com.example.taskl27redis.model.cache.CarCacheDto;
import com.example.taskl27redis.model.enums.CarStatus;
import com.example.taskl27redis.model.response.CarResponse;
import com.example.taskl27redis.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.example.taskl27redis.mapper.CarMapper.mapEntityToResponse;
import static com.example.taskl27redis.mapper.EntityToCacheMapper.CACHE_MAPPER;
import static java.time.temporal.ChronoUnit.MINUTES;


@Slf4j
@Service
@RequiredArgsConstructor

public class CarService {
    private final CarRepository carRepository;
    private final CacheUtil cacheUtil;


    public CarResponse getCar(Long id) {
        var car = fetchCarIfExits(id);
        var carCache = CACHE_MAPPER.mapEntityToCacheDto(car);
        saveToCache(carCache);
        return mapEntityToResponse(car);
    }

    public void saveToCache(CarCacheDto cacheDto) {
        cacheUtil.saveToCache(String.format("ms-car::car-id:::%d", cacheDto.getId()), cacheDto, 45L, MINUTES);
        log.info("saved to cache");
    }

    @PostConstruct
    public void getCache(){
        var data = cacheUtil.getBucket("ms-car::car-id::1");
        log.info("Data from Cache: {}", data);
    }


    private CarEntity fetchCarIfExits(Long id) {
        return carRepository.findByIdAndStatusNot(id, CarStatus.SOLD)
                .orElseThrow(RuntimeException::new);
    }
}

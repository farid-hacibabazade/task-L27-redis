package com.example.taskl27redis.dao.repository;



import com.example.taskl27redis.dao.entity.CarEntity;
import com.example.taskl27redis.model.enums.CarStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<CarEntity, Long> {

    Optional<CarEntity> findByIdAndStatusNot(Long id, CarStatus status);
}

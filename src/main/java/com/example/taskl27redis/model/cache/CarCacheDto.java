package com.example.taskl27redis.model.cache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarCacheDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String brand;
    private String model;
    private BigDecimal price;
}

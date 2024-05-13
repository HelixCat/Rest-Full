package com.mahdi.restfullapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDTO {

    private String name;
    private String color;
    private BigDecimal price;
    private Boolean exist;

}

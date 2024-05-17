package com.mahdi.restfullapi.dto;


import java.math.BigDecimal;

public record ProductRecordDTO(String name, String color, BigDecimal price, boolean exist) {
}

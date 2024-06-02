package com.mahdi.restfullapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Entity
@Table(name = "t_product")
@Getter
@Setter
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @NotNull
    @Column(name = "c_name", nullable = false)
    private String name;
    @NotBlank
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "c_color", length = 45, unique = true)
    private String color;
    @NotBlank
    @Column(name = "c_price", nullable = false)
    private BigDecimal price;
    @Column(name = "c_exist", nullable = false)
    private Boolean exist;

}

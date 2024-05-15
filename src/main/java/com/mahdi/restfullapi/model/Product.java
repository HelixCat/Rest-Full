package com.mahdi.restfullapi.model;

import jakarta.persistence.*;
import lombok.*;
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
    @Column(name = "c_name", nullable = false)
    private String name;
    @Column(name = "c_color", length = 45, unique = true)
    private String color;
    @Column(name = "c_price", nullable = false)
    private BigDecimal price;
    @Column(name = "c_exist", nullable = false)
    private Boolean exist;

}

package com.example.products.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String productName;
    @Column
    private String description;
    @Column
    private Double price;
    @Column
    private String status;
}

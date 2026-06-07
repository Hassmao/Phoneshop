package com.mao.java.school.phoneshop.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data    //using lombok
@Entity  //tell JPA this class should be store in DB
@Table(name = "brands")

public class Brand {
    @Id //tells JPA: this field is the unique identifier for this entity in the database.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //specifies how the primary key value will be created(means the database will handle primary key generation, usually with an auto-increment column)
    @Column(name = "brand_id")
    private Integer id;
    @Column(name = "brand_name")
    private String name;


}

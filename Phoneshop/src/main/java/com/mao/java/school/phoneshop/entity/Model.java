package com.mao.java.school.phoneshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "models")

public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer id;
    @Column(name = "model_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")

    //relationship to table brands field brand_id
    private Brand brand;
}

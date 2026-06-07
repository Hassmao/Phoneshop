package com.mao.java.school.phoneshop.services.util;

import com.mao.java.school.phoneshop.dto.BrandDTO;
import com.mao.java.school.phoneshop.entity.Brand;

//for convert field from Entity to DTO or DTO to Entity
public class Mapper {
    public static Brand toBrand(BrandDTO dto) {
        Brand brand = new Brand();
        brand.setId(dto.getId());
        brand.setName(dto.getName());
        return brand;
    }
}

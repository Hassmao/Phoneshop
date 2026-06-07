package com.mao.java.school.phoneshop.services;

import com.mao.java.school.phoneshop.dto.BrandDTO;
import com.mao.java.school.phoneshop.entity.Brand;

public interface BrandService {
    Brand create(Brand brand);
    Brand getById(int id);
    Brand update(Integer id, BrandDTO brandDTO);
    void delete(Integer id);

}

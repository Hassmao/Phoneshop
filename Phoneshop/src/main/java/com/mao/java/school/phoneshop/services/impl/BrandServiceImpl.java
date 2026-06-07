package com.mao.java.school.phoneshop.services.impl;

import com.mao.java.school.phoneshop.dto.BrandDTO;
import com.mao.java.school.phoneshop.entity.Brand;
import com.mao.java.school.phoneshop.repository.BrandRepository;
import com.mao.java.school.phoneshop.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
//It tells Spring’s component scanning: this class is a service, register it as a Spring Bean in the application context.
public class BrandServiceImpl implements BrandService {

    //no need create object on class, can use autowired for use external class
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);

    }

    @Override
    public Brand getById(int id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (brandOptional.isPresent()) {
            return brandOptional.get();
        }else{
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,  String.format("Brand with id %d not found", id));
        }
    }


    @Override
    public Brand update(Integer id, BrandDTO brandDTO) { //required id & request body
        //fine exiting brand by id
        Brand updateBrand = brandRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND,  String.format("Brand with id %d not found", id)));
        //update field from dto
        updateBrand.setName(brandDTO.getName());
        return brandRepository.save(updateBrand);
    }

    @Override
    public void delete(Integer id) {
        Brand deleteBrand = getById(id);
        brandRepository.delete(deleteBrand);
    }
}

package com.mao.java.school.phoneshop.controller;

import com.mao.java.school.phoneshop.dto.BrandDTO;
import com.mao.java.school.phoneshop.entity.Brand;
import com.mao.java.school.phoneshop.services.BrandService;
import com.mao.java.school.phoneshop.services.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//used to define a controller class where every method automatically returns a JSON or XML response instead of a view
@RequestMapping("brands") //used to map HTTP requests to controller methods (class_name)

//this class create for response data by API
public class BrandController {
    @Autowired
    private BrandService brandService; //call function save
    //function save
    @RequestMapping(method = RequestMethod.POST) //telling Spring MVC / Spring Boot that this method should handle HTTP POST requests.
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) { //the method will return an HTTP response (ResponseEntity) with a body of any type (? is a wildcard)
        Brand brand = Mapper.toBrand(brandDTO); //convert DTO to Entity
        brand = brandService.create(brand); //save data
        return ResponseEntity.ok(brand);// return HTTP response
    }
    //function getByID
    @GetMapping("{id}")
    public ResponseEntity<Brand> getById(@PathVariable ("id") int id) {
        return ResponseEntity.ok(brandService.getById(id));
    }

    //function Update
    @PutMapping("{id}")
    public ResponseEntity<Brand> update(@PathVariable ("id") int id, @RequestBody BrandDTO brandDTO) {
        Brand brand = Mapper.toBrand(brandDTO);
        return ResponseEntity.ok(brandService.update(id, brandDTO));
    }
    //function Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Brand> delete(@PathVariable ("id") int id) {
        Brand deleteBrand = brandService.getById(id);
        if (deleteBrand != null) {
            brandService.delete(id);
        }
        else ResponseEntity.notFound().build();
        return ResponseEntity.ok(deleteBrand);
    }


}

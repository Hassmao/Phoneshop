package com.mao.java.school.phoneshop.repository;

import com.mao.java.school.phoneshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer>
{
//this interface extend JPA to call CRUD Operation or function from library
}

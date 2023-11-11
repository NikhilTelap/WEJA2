package com.jspiders.cardekhocasestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.cardekhocasestudy.pojo.CarPOJO;

@Repository
public interface CarRepository extends JpaRepository<CarPOJO, Integer>{

	List<CarPOJO> findByName(String name);

	List<CarPOJO> findByBrand(String brand);

	List<CarPOJO> findByFuelType(String fuelType);

	
}

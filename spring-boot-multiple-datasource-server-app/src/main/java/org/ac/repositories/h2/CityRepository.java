package org.ac.repositories.h2;

import org.ac.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    City getCityByCityCode(Integer id);
}

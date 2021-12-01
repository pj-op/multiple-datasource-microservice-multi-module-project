package org.ac.service;

import org.ac.entities.City;

import java.util.List;

public interface ICityService {
    List<City> getAllCities();

    City saveCity(City city);

    City getCityById(Integer id);
}

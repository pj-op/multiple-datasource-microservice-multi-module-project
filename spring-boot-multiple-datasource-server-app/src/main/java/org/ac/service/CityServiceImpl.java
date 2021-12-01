package org.ac.service;

import org.ac.entities.City;
import org.ac.repositories.h2.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        List<City> list = cityRepository.findAll();
        return list;
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City getCityById(Integer id) {
        City city = cityRepository.getCityByCityCode(id);
        return city;
    }
}

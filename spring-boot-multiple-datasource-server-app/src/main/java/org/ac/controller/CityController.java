package org.ac.controller;

import org.ac.entities.City;
import org.ac.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cities")
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public City getCity(@PathVariable("id") Integer id) {
        return cityService.getCityById(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCities(@RequestBody City city) {
        City city1 = cityService.saveCity(city);
        return ResponseEntity.ok(city1);
    }

}

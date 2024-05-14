package org.ac.service;

import org.ac.entities.City;
import org.ac.repositories.h2.CityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    @DisplayName("Should return all cities")
    void getAllCitiesShouldReturnAllCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City(1, "Kiev", 12345));
        cities.add(new City(2, "Lviv", 54321));
        when(cityRepository.findAll()).thenReturn(cities);

        List<City> result = cityService.getAllCities();

        assertEquals(2, result.size());
        assertEquals("Kiev", result.get(0).getCityName());
        assertEquals("Lviv", result.get(1).getCityName());
    }
}
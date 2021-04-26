package com.webDevelopment.turistar.citiesTests.unit;

import com.webDevelopment.turistar.Administrator.City.Application.All.CitiesAll;
import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.ArrayList;
import java.util.List;

import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityCountry;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityName;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CitiesTest {

    List<City> cities;

    @BeforeEach
    public void init(){
        cities = new ArrayList<>();
        cities.add( new City(new CityId("a0619482-a621-11eb-bcbc-0242ac130002"), new CityName("Bogotá"),new CityCountry("Colombia")) );
        cities.add( new City(new CityId("a06197e8-a621-11eb-bcbc-0242ac130002"), new CityName("Medellín"),new CityCountry("Colombia")) );
        cities.add( new City(new CityId("a06198e2-a621-11eb-bcbc-0242ac130002"), new CityName("Bucaramanga"),new CityCountry("Colombia")) );
    }

    @Test
    public void getAllCitiesTest(){
        //instanciar repositorio
        CityRepository cityRepository = mock(CityRepository.class);
        //asignar datos al objeto mock
        Mockito.when(cityRepository.all()).thenReturn(Optional.of(cities));
        //instanciar caso de uso
        CitiesAll citiesAll = new CitiesAll(cityRepository);

        assertEquals(cities, citiesAll.execute());
    }
}

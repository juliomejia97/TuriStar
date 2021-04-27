package com.webDevelopment.turistar.citiesTests.unit;

import com.webDevelopment.turistar.Administrator.City.Application.All.CitiesAll;
import com.webDevelopment.turistar.Administrator.City.Application.Update.CityModifier;
import com.webDevelopment.turistar.Administrator.City.Domain.City;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.CityRepository;

import java.util.ArrayList;
import java.util.List;

import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityCountry;
import com.webDevelopment.turistar.Administrator.City.Domain.ValueObjects.CityName;
import com.webDevelopment.turistar.Shared.Domain.City.CityId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CitiesTest {

    private List<City> cities;
    private City cityToUpdate;

    @BeforeEach
    public void init(){
        cities = new ArrayList<>();
        cities.add( new City(new CityId("a0619482-a621-11eb-bcbc-0242ac130002"), new CityName("Bogotá"),new CityCountry("Colombia")) );
        cities.add( new City(new CityId("a06197e8-a621-11eb-bcbc-0242ac130002"), new CityName("Medellín"),new CityCountry("Colombia")) );
        cities.add( new City(new CityId("a06198e2-a621-11eb-bcbc-0242ac130002"), new CityName("Bucaramanga"),new CityCountry("Colombia")) );

        cityToUpdate = new City(new CityId("a0619482-a621-11eb-bcbc-0242ac130002"), new CityName("Tunja"),new CityCountry("Colombia"));
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

    @Test
    public void updateCityTest(){
        CityRepository cityRepository = mock(CityRepository.class);
        Mockito.when(cityRepository.find("a0619482-a621-11eb-bcbc-0242ac130002")).thenReturn(Optional.of(cities.get(0)));
        CityModifier cityModifier = new CityModifier(cityRepository);
        cityModifier.execute("a0619482-a621-11eb-bcbc-0242ac130002","Tunja","Colombia");
        verify(cityRepository,atLeastOnce()).update("a0619482-a621-11eb-bcbc-0242ac130002",cityToUpdate);
    }
}

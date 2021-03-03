package com.oceanngrsmith.ocheejeh.hublocker.services.impl;

import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import com.oceanngrsmith.ocheejeh.hublocker.repository.CityRepo;
import com.oceanngrsmith.ocheejeh.hublocker.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * handle all database
 * interaction involving
 * city
 */
@Service
public class CityServiceImpl implements CityService {
    private CityRepo cityRepository;

    @Autowired
    public void setCityRepository(CityRepo cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City saveOrUpdate(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> saveCities(List<City> cities) {
        return cityRepository.saveAll(cities);
    }
}

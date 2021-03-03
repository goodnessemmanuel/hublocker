package com.oceanngrsmith.ocheejeh.hublocker.services;

import com.oceanngrsmith.ocheejeh.hublocker.models.City;

import java.util.List;

public interface CityService {
    City saveOrUpdate(City city);
    List<City> saveCities(List<City> cities);
}

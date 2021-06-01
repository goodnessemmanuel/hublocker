package com.oceanngrsmith.ocheejeh.hublocker.repository;

import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    City findByName(String cityName);
}

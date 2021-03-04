package com.oceanngrsmith.ocheejeh.hublocker.repository;

import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import com.oceanngrsmith.ocheejeh.hublocker.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockerRepo extends JpaRepository<Locker, Long> {
    List<Locker> findByCity(City city);
    List<Locker> findByState(State state);
    Long countByCity(City city);
}

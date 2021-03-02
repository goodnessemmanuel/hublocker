package com.oceanngrsmith.ocheejeh.hublocker.services;

import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;

import java.util.List;

public interface LockerService {
    List<Locker> listAllLockers();
    List<Locker> findLockerByState(String nameOfState);
    List<Locker> findLockerByCity(String nameOfState);
}

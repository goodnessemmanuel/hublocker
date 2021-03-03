package com.oceanngrsmith.ocheejeh.hublocker.services;

import com.oceanngrsmith.ocheejeh.hublocker.dto.LockerDTO;
import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import com.oceanngrsmith.ocheejeh.hublocker.models.State;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LockerService {
    Locker saveLocker(Locker locker);
    List<Locker> saveLockers(List<Locker> lockers);
    /*ResponseEntity<List<Locker>> listAllLockers();*/
    ResponseEntity<List<LockerDTO>> listAllLockers();
    ResponseEntity<List<LockerDTO>> listAllLockersByState(String nameOfState);
    ResponseEntity<List<LockerDTO>> listAllLockersByCity(String nameOfCity);
    List<LockerDTO> convertLockersToDTO(List<Locker> lockers);
}

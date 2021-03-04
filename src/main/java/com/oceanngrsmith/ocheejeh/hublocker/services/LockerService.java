package com.oceanngrsmith.ocheejeh.hublocker.services;

import com.oceanngrsmith.ocheejeh.hublocker.dto.LockerDTO;
import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LockerService {
    Locker saveLocker(Locker locker);
    List<Locker> saveLockers(List<Locker> lockers);
    ResponseEntity<List<LockerDTO>> listLockersByStateOrCity(String cityOrState);
    ResponseEntity<List<LockerDTO>> listAllLockers();
    List<LockerDTO> convertLockersToDTO(List<Locker> lockers);
    Long countLockersByCity(City city);
}

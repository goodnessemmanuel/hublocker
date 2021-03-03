package com.oceanngrsmith.ocheejeh.hublocker.services.impl;

import com.oceanngrsmith.ocheejeh.hublocker.dto.LockerDTO;
import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import com.oceanngrsmith.ocheejeh.hublocker.models.State;
import com.oceanngrsmith.ocheejeh.hublocker.repository.CityRepo;
import com.oceanngrsmith.ocheejeh.hublocker.repository.LockerRepo;
import com.oceanngrsmith.ocheejeh.hublocker.repository.StateRepo;
import com.oceanngrsmith.ocheejeh.hublocker.services.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LockerServiceImpl implements LockerService {

    private final LockerRepo lockerRepo;
    private final CityRepo cityRepo;
    private final StateRepo stateRepo;

    @Autowired
    public LockerServiceImpl(LockerRepo lockerRepo, CityRepo cityRepo, StateRepo stateRepo) {
        this.lockerRepo = lockerRepo;
        this.cityRepo = cityRepo;
        this.stateRepo = stateRepo;
    }

    @Override
    public Locker saveLocker(Locker locker) {
        return lockerRepo.save(locker);
    }

    @Override
    public List<Locker> saveLockers(List<Locker> lockers) {
        return lockerRepo.saveAll(lockers);
    }

    @Override
    public ResponseEntity<List<LockerDTO>> listAllLockers() {
        return ResponseEntity.ok(convertLockersToDTO(lockerRepo.findAll()));
    }

    @Override
    public ResponseEntity<List<LockerDTO>> listAllLockersByCity(String nameOfCity) {
        City targetCity = cityRepo.findByName(nameOfCity);
        List<Locker> lockers = lockerRepo.findByCity(targetCity);
        return  ResponseEntity.ok(convertLockersToDTO(lockers));
    }

    @Override
    public ResponseEntity<List<LockerDTO>> listAllLockersByState(String nameOfState) {
        State targetState = stateRepo.findByName(nameOfState);
        List<Locker> lockers = lockerRepo.findByState(targetState);

        return  ResponseEntity.ok(convertLockersToDTO(lockers));
    }

    @Override
    public List<LockerDTO> convertLockersToDTO(List<Locker> lockers) {
        return lockers.stream()
                .map(locker -> new LockerDTO(locker.getId(), locker.getName(), locker.getState().getName(),
                        locker.getCity().getName(), locker.getPriceDetail(), locker.getDateCreated()))
                .collect(Collectors.toList());
    }

}

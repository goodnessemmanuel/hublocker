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

import java.util.ArrayList;
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
    public ResponseEntity<List<LockerDTO>> listLockersByStateOrCity(String cityOrState) {
        State state; City city;
        List<Locker> lockers = new ArrayList<>();

        if((state = stateRepo.findByName(cityOrState)) != null) lockers = lockerRepo.findByState(state);
        else if((city = cityRepo.findByName(cityOrState)) != null) lockers = lockerRepo.findByCity(city);

        return  ResponseEntity.ok(convertLockersToDTO(lockers));
    }

    @Override
    public List<LockerDTO> convertLockersToDTO(List<Locker> lockers) {
        return lockers.stream()
                .map(locker -> new LockerDTO(locker.getId(), locker.getCity().getLockers().size(),
                        locker.getName(), locker.getState().getName(), locker.getCity().getName(),
                        locker.getPriceDetail(), locker.getFirstRent()))
                .collect(Collectors.toList());
    }

    @Override
    public Long countLockersByCity(City city) {
        return lockerRepo.countByCity(city);
    }

}

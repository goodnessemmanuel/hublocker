package com.oceanngrsmith.ocheejeh.hublocker.services.impl;

import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import com.oceanngrsmith.ocheejeh.hublocker.repos.LockerRepo;
import com.oceanngrsmith.ocheejeh.hublocker.services.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockerServiceImpl implements LockerService {

    private final LockerRepo lockerRepo;

    @Autowired
    public LockerServiceImpl(LockerRepo lockerRepo){
        this.lockerRepo = lockerRepo;
    }

    /*@Override
    public Locker addLocker(Locker locker) {
        return lockerRepo.save(locker);
    }*/

    @Override
    public List<Locker> listAllLockers() {
        return lockerRepo.findAll();
    }

    @Override
    public List<Locker> findLockerByState(String nameOfState) {
        return null;
    }

    @Override
    public List<Locker> findLockerByCity(String nameOfState) {
        return null;
    }

}

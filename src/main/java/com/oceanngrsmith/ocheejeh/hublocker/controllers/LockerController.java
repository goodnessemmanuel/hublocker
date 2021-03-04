package com.oceanngrsmith.ocheejeh.hublocker.controllers;

import com.oceanngrsmith.ocheejeh.hublocker.dto.LockerDTO;
import com.oceanngrsmith.ocheejeh.hublocker.services.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller handles
 * all incoming api
 * requests and returns
 * corresponding payload
 */
@RestController
@RequestMapping("/api/v1/")
public class LockerController {

    private final LockerService lockerService;

    @Autowired
    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    @GetMapping({"/", "lockers"})
    public ResponseEntity<List<LockerDTO>> getLocationLockers(){
        return lockerService.listAllLockers();
    }

    @GetMapping("lockers/search")
    public ResponseEntity<List<LockerDTO>> getLockersByStateOrCity(@RequestParam String key){
        return lockerService.listLockersByStateOrCity(key);
    }

}

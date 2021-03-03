package com.oceanngrsmith.ocheejeh.hublocker.services.impl;

import com.oceanngrsmith.ocheejeh.hublocker.models.State;
import com.oceanngrsmith.ocheejeh.hublocker.repository.StateRepo;
import com.oceanngrsmith.ocheejeh.hublocker.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * handle all database
 * interaction for state
 */
@Service
public class StateServiceImpl implements StateService {
    private final StateRepo stateRepository;

    @Autowired
    public StateServiceImpl(StateRepo stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State saveOrUpdate(State state) {
        return stateRepository.save(state);
    }

    @Override
    public List<State> saveStates(List<State> states) {
      return   stateRepository.saveAll(states);
    }

}

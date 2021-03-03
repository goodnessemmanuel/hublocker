package com.oceanngrsmith.ocheejeh.hublocker.services;

import com.oceanngrsmith.ocheejeh.hublocker.models.State;

import java.util.List;

public interface StateService {
    State saveOrUpdate(State state);
    List<State> saveStates(List<State> states);
}

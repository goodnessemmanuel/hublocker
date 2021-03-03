package com.oceanngrsmith.ocheejeh.hublocker.repository;

import com.oceanngrsmith.ocheejeh.hublocker.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepo extends JpaRepository<State, Long> {
    State findByName(String name);
}

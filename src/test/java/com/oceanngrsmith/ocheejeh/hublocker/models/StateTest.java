package com.oceanngrsmith.ocheejeh.hublocker.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class StateTest {
    @Test
    void shouldAccessFieldsProperly(){
        ModelTestUtil.validateAccessors(State.class);
    }

    @Test
    @DisplayName("Should accept new city")
    void shouldAddCity(){
        State state = new State("Benue", "Food Basket");
        state.updateTimeStamps();

        City city1 = new City();
        city1.setName("Makurdi");
        city1.addLocker(new Locker());

        City city2 = new City(state, "PortHarcourt");
        state.addCity(city1);
        state.addCity(city2);
        state.addCity(city2); //ignore duplicates

        assertAll(
                () -> assertEquals(2, state.getCities().size(), "Should return total cities without duplicate"),
                () -> assertNotNull(state.getDateCreated(), "State must have date created")
        );
    }
}

package com.oceanngrsmith.ocheejeh.hublocker.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;


class CityTest {

    @Test
    @DisplayName("Should properly access getters and setters")
    void shouldAccessFieldsProperly(){
        ModelTestUtil.validateAccessors(City.class);
    }

    @Test
    @DisplayName("Should add new locker to city")
    void shouldAddLockerToCity(){
        City city = new City(new State("Rivers"), "PortHarcourt");
        city.setDateCreated(new Date());
        city.updateTimeStamps();

        Locker locker = new Locker("test", "450 per item");
        city.addLocker(locker);

        assert city.getLockers().size() == 1;
    }
}

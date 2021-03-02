package com.oceanngrsmith.ocheejeh.hublocker.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LockerTest {
    @Test
    @DisplayName("Should properly access getters and setters")
    void shouldAccessFieldsProperly(){
        ModelTestUtil.validateAccessors(Locker.class);
    }
}
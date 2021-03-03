package com.oceanngrsmith.ocheejeh.hublocker.controllers;

import com.oceanngrsmith.ocheejeh.hublocker.dto.LockerDTO;
import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import com.oceanngrsmith.ocheejeh.hublocker.models.State;
import com.oceanngrsmith.ocheejeh.hublocker.services.LockerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class LockerControllerTest {
    @Mock
    private LockerService lockerService;

    @InjectMocks
    private LockerController lockerController;

    @Test
    @DisplayName("Should correctly route location lockers endpoint")
    void shouldRouteEndpointCorrectly() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(lockerController).build();
        mockMvc.perform(get("/api/v1/lockers"))
                .andExpect(status().isOk());
        verify(lockerService, times(1)).listAllLockers();
    }

    @Test
    @DisplayName("Should detect empty list")
    void whenThereAreNoLockers(){
        when(lockerService.listAllLockers()).thenReturn(ResponseEntity.ok(new ArrayList<>()));

        ResponseEntity<List<LockerDTO>> responseEntity = lockerController.getLocationLockers();
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals(0, responseEntity.getBody().size())
        );
        verify(lockerService, times(1)).listAllLockers();
    }

    @Test
    @DisplayName("Should correctly return list of location lockers")
    void shouldReturnListOfLockers(){
        LockerDTO locker1 = new LockerDTO();
        locker1.setName("Small H295");
        locker1.setPriceDetail("N450 per item/mo");

        LockerDTO locker2 = new LockerDTO();
        locker2.setName("Medium HX85");
        locker2.setPriceDetail("N450 per item/mo");

        when(lockerService.listAllLockers()).thenReturn(ResponseEntity.ok(List.of(locker1, locker2)));

        ResponseEntity<List<LockerDTO>> responseEntity = lockerController.getLocationLockers();
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals(2, responseEntity.getBody().size()),
                () -> assertEquals("Small H295", responseEntity.getBody().get(0).getName()),
                () -> assertEquals("Medium HX85", responseEntity.getBody().get(1).getName())
        );
        verify(lockerService, times(1)).listAllLockers();
    }

    @Test
    void shouldGetLockersByCity(){
        City city1 = new City();
        city1.setName("Port Harcourt");
        City city2 = new City(new State(), "Abuja");
        Locker locker1 = new Locker();
        locker1.setName("Small H295");
        locker1.setPriceDetail("N450 per item/mo");


        Locker locker2 = new Locker("Medium HX85", "N450 per item/mo");

        city1.addLocker(locker1);
        city2.addLocker(locker2);
    }
}
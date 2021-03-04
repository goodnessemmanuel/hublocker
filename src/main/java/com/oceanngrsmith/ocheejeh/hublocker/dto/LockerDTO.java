package com.oceanngrsmith.ocheejeh.hublocker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LockerDTO {
    private Long id;
    private Integer totalLockersPerCity;
    private String name;
    private String state;
    private String city;
    private String priceDetail;
    private String firstRent;
}

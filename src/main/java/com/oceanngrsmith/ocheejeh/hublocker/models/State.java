package com.oceanngrsmith.ocheejeh.hublocker.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * blue print for
 * creation of state
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class State extends BaseModel{
    private String name;
    private String title;

    @OneToMany(mappedBy = "state", orphanRemoval = true)
    private Set<City> cities = new HashSet<>();

    @OneToMany(mappedBy = "state", orphanRemoval = true)
    private List<Locker> lockers = new ArrayList<>();

    public State(String name){
        this(name, "Not Set");
    }

    public State(String name, String title){
        this.name = name;
        this.title = title;
    }

    public void addCity(City city){
        city.setState(this);
        cities.add(city);
    }
}

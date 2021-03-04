package com.oceanngrsmith.ocheejeh.hublocker.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This entity is use
 * to create a city
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class City extends BaseModel{

    private String name;

    @ManyToOne
    private State state;

    @OneToMany(mappedBy = "city", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Locker> lockers = new ArrayList<>();

    public City(State state, String name) {
        this.name = name;
        this.state = state;
    }

    public void addLocker(Locker locker) {
        locker.setCity(this);
        this.lockers.add(locker);
    }
}

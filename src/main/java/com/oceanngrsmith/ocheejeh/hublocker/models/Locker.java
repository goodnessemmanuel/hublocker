package com.oceanngrsmith.ocheejeh.hublocker.models;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Locker extends BaseModel{

    private String name;
    private String priceDetail;

    @ManyToOne
    private City city;

    public Locker(String name, String priceDetail) {
        this.name = name;
        this.priceDetail = priceDetail;
    }
}

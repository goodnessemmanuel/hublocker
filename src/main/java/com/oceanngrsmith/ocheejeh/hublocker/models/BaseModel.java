package com.oceanngrsmith.ocheejeh.hublocker.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Version
    private Integer version;

    private Date dateCreated;
    private Date lastUpdated;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated == null) {
            dateCreated = new Date();
        }
    }
}

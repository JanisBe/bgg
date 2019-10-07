package com.janis.bgg.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Settings {
    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private LocalDate lastModificationDate;

    public Settings(String userName, LocalDate lastModificationDate) {
        this.userName = userName;
        this.lastModificationDate = lastModificationDate;
    }
}

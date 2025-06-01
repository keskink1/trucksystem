package com.keskin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Letter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String letter;

    public Letter() {
    }

    public Letter(int id, String letter) {
        this.id = id;
        this.letter = letter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}

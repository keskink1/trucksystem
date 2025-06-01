package com.keskin.model;

import javax.persistence.*;

@Entity
public class Driver {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String first_name;
    private String last_name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    public Driver() {
    }

    public Driver(int id, String first_name, String last_name, int age, Roles roles) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.roles = roles;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

}

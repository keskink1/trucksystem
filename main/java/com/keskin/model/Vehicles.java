package com.keskin.model;

public enum Vehicles {
    CAR("car"),
    TRUCK("truck"),
    BUS("bus"),
    SHIP("ship"),
    PLANE("plane");

    private final String vehicle;

    Vehicles(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }
}

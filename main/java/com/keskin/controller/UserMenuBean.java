package com.keskin.controller;

import com.keskin.model.Vehicles;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserMenuBean {
    private List<Vehicles> vehiclesList;
    private List<Vehicles> selectedVehicles;

    @PostConstruct
    public void init(){
        vehiclesList = Arrays.asList(Vehicles.values());
        selectedVehicles = new ArrayList<>();
    }

    public void submit(){
        // insert to db, assign to the user
    }

    public List<Vehicles> getVehiclesList() {
        return vehiclesList;
    }

    public void setVehiclesList(List<Vehicles> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }

    public List<Vehicles> getSelectedVehicles() {
        return selectedVehicles;
    }

    public void setSelectedVehicles(List<Vehicles> selectedVehicles) {
        this.selectedVehicles = selectedVehicles;
    }
}

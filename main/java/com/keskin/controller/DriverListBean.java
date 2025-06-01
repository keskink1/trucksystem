package com.keskin.controller;

import com.keskin.DAO.UserDAO;
import com.keskin.model.Driver;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "driverlistbean")
public class DriverListBean {
    private List<Driver> driverList;

    @EJB
    private UserDAO userDAO;

    @PostConstruct
    public void init(){
        driverList = userDAO.getAllDrivers();

    }


    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

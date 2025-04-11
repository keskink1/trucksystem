package com.keskin.controller;

import com.keskin.DAO.LoginDAO;
import com.keskin.model.Driver;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "login")
public class LoginBean {
    private String firstname;
    private String lastname;
    private Driver driver;

    @EJB
    private LoginDAO loginDAO;

    @ManagedProperty("#{sessionScopeBean}")
    SessionScopeBean sessionScopeBean;

    public String  checkUser(){
        boolean result = loginDAO.checkUser(firstname,lastname);

        if (result){
            driver = loginDAO.getDriver(firstname,lastname);
            sessionScopeBean.setDriver(driver);
            return "welcome";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Wrong credentials", "One of the login credentials is wrong"));
        return "login";
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public SessionScopeBean getSessionScopeBean() {
        return sessionScopeBean;
    }

    public void setSessionScopeBean(SessionScopeBean sessionScopeBean) {
        this.sessionScopeBean = sessionScopeBean;
    }

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
}

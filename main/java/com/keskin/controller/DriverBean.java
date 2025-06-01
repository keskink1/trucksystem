package com.keskin.controller;

import com.keskin.DAO.RegisterDAO;
import com.keskin.model.Roles;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "driver")
@RequestScoped
public class DriverBean {

    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private Roles roles;
    private List<Roles> roleList;

    @EJB
    private RegisterDAO registerDAO;

    @PostConstruct
    public void init(){
        roleList = new ArrayList<>();
        roleList.addAll(Arrays.asList(Roles.values()));

    }

    public String registerUser(){
        boolean result = registerDAO.doesUserExistOnDB(firstname, lastname);

        if (!result){
            registerDAO.registerUser(firstname,lastname,age,roles);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Register successful","User registered successfully!"));
            return "register?faces-redirect=true";
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"User exists", "This user already exists!"));
            return "register";
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Roles> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Roles> roleList) {
        this.roleList = roleList;
    }


    public RegisterDAO getRegisterDAO() {
        return registerDAO;
    }

    public void setRegisterDAO(RegisterDAO registerDAO) {
        this.registerDAO = registerDAO;
    }
}

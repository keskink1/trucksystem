package com.keskin.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DashboardBean {
    private boolean enableButton = false;

    public String proceed() {
        return "userpanel?faces-redirect=true";
    }

    public boolean isEnableButton() {
        return enableButton;
    }

    public void setEnableButton(boolean enableButton) {
        this.enableButton = enableButton;
    }


}

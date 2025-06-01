package com.keskin.listener;

import com.keskin.DAO.LetterDAO;
import com.keskin.model.Letter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "checkboxBean")
@ViewScoped
public class UserPanelBean {
    private boolean checked;
    private String description;

    @EJB
    private LetterDAO letterDAO;

    public void onTickCheckbox() {
        if (!checked)
            description = null;
    }

    public void saveTextToDB(){
        if (description.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Description is empty", "Description can't be empty!"));
        }else {
            letterDAO.saveLetterToDB(this.description);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Message sent", "Your message is successfully sent!"));
            description = null;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public LetterDAO getLetterDAO() {
        return letterDAO;
    }

    public void setLetterDAO(LetterDAO letterDAO) {
        this.letterDAO = letterDAO;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bellacraine
 */
@Named(value = "personalDataBean")
@RequestScoped
public class personalDataBean {

    /**
     * Creates a new instance of personalDataBean
     */
    private Integer personPk;
    private String username;
    private String role;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPersonPk() {
        return personPk;
    }

    public void setPersonPk(Integer personPk) {
        this.personPk = personPk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public personalDataBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        personPk = (Integer) session.getAttribute("personPk");
        username = (String) session.getAttribute("username");
        role = (String) session.getAttribute("role");
        loadPersonalData();
    }

//--------------------------------------- Container für Username & Passwort
    private InputPayloadPerson parameter;

    public InputPayloadPerson getParameter() {
        return parameter;
    }

    public void setParameter(InputPayloadPerson parameter) {
        this.parameter = parameter;
    }

    //---------------------------------------
    public void loadPersonalData() {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter = new InputPayloadPerson();
        parameter.setPersonPk(personPk);      //Vorbereitung der Daten welche über das WS transportiert werden sollen

        OutputPayloadPerson opl = port.loadPersonDetails(parameter); //Der eigentliche Aufruf des WebServices (Synchron)

        firstName = opl.getName();
        lastName = opl.getLastname();
    }

    public void updatePersonalData() {

    }
}

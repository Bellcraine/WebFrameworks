/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
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
    private String password;
    private String confirmPassword;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String addPersonalData() {

        if (!username.equals("") && !password.equals("") && password.equals(confirmPassword)) {

            StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
            StudyServices port = service.getStudyServicesPort();

            parameter = new InputPayloadPerson(); //Vorbereitung der Daten welche über das WS transportiert werden sollen
            parameter.setUsername(username);
            parameter.setName(firstName);
            parameter.setLastname(lastName);
            parameter.setRole(role);
            parameter.setPassword(password);

            boolean opl = port.addOrUpdatePerson(parameter); //Der eigentliche Aufruf des WebServices (Synchron)

            showMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "You were registered successfully. You can login now.");
            return "index";
        } else {
            showMessage(FacesMessage.SEVERITY_ERROR, "FAILURE", "You could not be registered.");
            return "userRegistration";
        }

//     * addOrUpdatePerson input: person (all parameters exept password and pk
//     * (both optional)) 
//case 1 no primary key / with password -> person will be
//     * created (password required!) 
//case 2 with primary key / no password ->
//     * person will be updated (password stays the same) 
//case 3 with primary key
//     * / with password -> person will be updated completely output: true / false
    }

    public String updatePersonalData() {
        if (!username.equals("") && password.equals(confirmPassword)) {

            StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
            StudyServices port = service.getStudyServicesPort();

            parameter = new InputPayloadPerson(); //Vorbereitung der Daten welche über das WS transportiert werden sollen
            parameter.setPersonPk(personPk);
            parameter.setUsername(username);
            parameter.setName(firstName);
            parameter.setLastname(lastName);
            parameter.setRole(role);
            parameter.setPassword(password);

            boolean opl = port.addOrUpdatePerson(parameter); //Der eigentliche Aufruf des WebServices (Synchron)

            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("username", username);

            showMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "Your personal data was updated successfully.");
            if (role.equals("student")) {
                return "userInfo";
            } else {
                return "lecturerUserInfo";
            }
        } else {
            showMessage(FacesMessage.SEVERITY_ERROR, "FAILURE", "Your personal data could not be updated.");
            if (role.equals("student")) {
                return "personalData";
            } else {
                return "lecturerPersonalData";
            }

        }
    }

    public void showMessage(FacesMessage.Severity severity, String title, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, title, details));
    }
}

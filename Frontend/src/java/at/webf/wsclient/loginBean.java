/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PU
 */
@Named // Wichtig um die Klasse zum Binding für die index.xhtml Seite zu klassifizieren (Binding wird in faces-config.xml durchgeführt)
@SessionScoped
public class loginBean implements Serializable {

    // Input
    // Variablen zum Binding für index.xhtml
    private String username;
    private String password;

    // Output
    private Integer personPk;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public String login() { //Login-methode, wird ausgeführt wenn der Button in index.xhtml geklickt wird.

        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter = new InputPayloadPerson();
        parameter.setUsername(username);      // Vorbereitung der Daten welche über das WS transportiert werden sollen
        parameter.setPassword(password);

        OutputPayloadPerson opl = port.login(parameter); //Der eigentliche Aufruf des WebServices (Synchron)

        personPk = opl.getPersonPk();
        username = opl.getUsername();
        role = opl.getRole();

        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

        if (opl.getPersonPk() == null) {
            showMessage(FacesMessage.SEVERITY_ERROR, "FAILURE", "You were not able to log in.");
            return "index";
        } else if (opl.getPersonPk() != null && opl.getRole().equals("lecturer")) { //Auslesen der Resultate
            session.setAttribute("personPk", personPk);
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            showMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "You were logged in successfully.");
            return "lecturerUserInfo";
        } else if (opl.getPersonPk() != null && opl.getRole().equals("student")) {
            session.setAttribute("personPk", personPk);
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            showMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "You were logged in successfully.");
            return "userInfo";
        } else {
            return "index";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        showMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "You were logged out successfully.");
        return "index";
    }

    public void showMessage(FacesMessage.Severity severity, String title, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, title, details));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tommy
 */
@Named
@RequestScoped
public class userInfoBean implements Serializable {

    private Integer personPk;
    private String username;
    private String role;

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
//--------------------------------------- Container für Username & Passwort
    private InputPayloadPerson parameter;

    public InputPayloadPerson getParameter() {
        return parameter;
    }

    public void setParameter(InputPayloadPerson parameter) {
        this.parameter = parameter;
    }

    //---------------------------------------
    public userInfoBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        
        personPk = (Integer) session.getAttribute("personPk");
//        username = (String) session.getAttribute("username");
        role = (String) session.getAttribute("role");

        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter = new InputPayloadPerson(); //Vorbereitung der Daten welche über das WS transportiert werden sollen
        parameter.setPersonPk(personPk);

        OutputPayloadPerson opl = port.loadPersonDetails(parameter);
        
        username = opl.getUsername();

    }

}

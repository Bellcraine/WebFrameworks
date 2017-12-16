/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


/**
 *
 * @author PU
 */
@Named //Wichtig um die Klasse zum Binding für die index.xhtml Seite zu klassifizieren (Binding wird in faces-config.xml durchgeführt)
public class LoginFrontend implements Serializable {

    //Variablen zum Binding für index.xhtml
    private String username;
    private String password;
    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
    private InputPayloadLogin parameter;

    public InputPayloadLogin getParameter() {
        return parameter;
    }

    public void setParameter(InputPayloadLogin parameter) {
        this.parameter = parameter;
    }

    //---------------------------------------
    public String login() { //Login-methode, wird ausgeführt wenn der Button in index.xhtml geklickt wird.

        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();
        parameter = new InputPayloadLogin();

        parameter.setUsername(username);      //Vorbereitung der Daten welche über das WS transportiert werden sollen
        parameter.setPassword(password);

        OutputPayloadLogin opl = port.login(parameter); //Der eigentliche Aufruf des WebServices (Synchron)

        String fehlerbeschreibung = opl.getFehlerbeschreibung(); //Auslesen der Resultate
        userid = opl.getUserid();

        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("userid", userid);

        return "Home";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ws.Output;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PU
 */
@XmlRootElement
public class OutputPayloadLogin {
    
    private Integer fehlercode;
    private String fehlerbeschreibung;
    private Integer userid;
    private String role;

    public Integer getFehlercode() {
        return fehlercode;
    }

    public void setFehlercode(Integer fehlercode) {
        this.fehlercode = fehlercode;
    }

    public String getFehlerbeschreibung() {
        return fehlerbeschreibung;
    }

    public void setFehlerbeschreibung(String fehlerbeschreibung) {
        this.fehlerbeschreibung = fehlerbeschreibung;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
        public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}

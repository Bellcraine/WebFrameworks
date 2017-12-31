/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bellacraine
 */
@Named(value = "studentManagerBean")
@RequestScoped
public class studentManagerBean {

    /**
     * Creates a new instance of studentManagerBean
     */
    private String username;
    private Course course;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public studentManagerBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        course = (Course) session.getAttribute("course");
        username = (String) session.getAttribute("username");
    }

   

}

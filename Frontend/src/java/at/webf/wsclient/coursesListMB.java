/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tommy
 */
@Named(value = "coursesListMB")
@SessionScoped
public class coursesListMB implements Serializable {

    private Integer course_pk;
    private String title;
    private String description;
    
    private ArrayList<Course> courses;
    

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Integer getCourse_pk() {
        return course_pk;
    }

    public void setCourse_pk(Integer course_pk) {
        this.course_pk = course_pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
    /**
     * Creates a new instance of coursesListMB
     */
    public coursesListMB() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        courses = (ArrayList<Course>) session.getAttribute("courses");
    }
    
}

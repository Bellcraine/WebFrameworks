/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tommy
 */
@Named
public class userInfoBean implements Serializable {

    private Integer userId;
//    private ArrayList<Course> courses = new ArrayList<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

//    public ArrayList<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(ArrayList<Course> courses) {
//        this.courses = courses;
//    }

    public userInfoBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        userId = (Integer) session.getAttribute("userid");
        
    }

    
}

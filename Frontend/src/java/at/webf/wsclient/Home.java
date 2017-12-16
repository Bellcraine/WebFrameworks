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
//import domainModels.Course;

/**
 *
 * @author Tommy
 */
@Named
public class Home implements Serializable {

    private Integer userId;

    private Integer course_pk;
    private String title;
    private String description;
    
    private ArrayList<Course> courses = new ArrayList<>();

    
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Home() {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        userId = (Integer) session.getAttribute("userid");
        loadCourses();

    }

    //---------------------------------------
    public void loadCourses() { //Login-methode, wird ausgeführt wenn der Button in index.xhtml geklickt wird.

        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();
        // parameter = new InputPayloadLogin();

        //parameter.setUsername(username);      //Vorbereitung der Daten welche über das WS transportiert werden sollen
        // parameter.setPassword(password);
        OutputPayloadCourse opl = port.getCourses(); //Der eigentliche Aufruf des WebServices (Synchron)

        //String fehlerbeschreibung = opl.getFehlerbeschreibung(); //Auslesen der Resultate
        //userid = opl.getUserid();
//        course_pk = opl.getCoursePk();
//        title = opl.getTitle();
//        description = opl.getDescription();
        courses = (ArrayList<Course>) opl.getCourses();

//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
////        session.setAttribute("userid", userid);
//            session.setAttribute("courses", courses);



 
    }

}

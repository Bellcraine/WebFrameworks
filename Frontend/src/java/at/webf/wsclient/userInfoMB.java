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
public class userInfoMB implements Serializable {

    private Integer userId;
    private ArrayList<Course> courses = new ArrayList<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public userInfoMB() {
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

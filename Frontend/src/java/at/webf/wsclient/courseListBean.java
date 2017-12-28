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
public class courseListBean implements Serializable {

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

    /**
     * Creates a new instance of coursesListMB
     */
    public courseListBean() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//        courses = (ArrayList<Course>) session.getAttribute("courses");
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

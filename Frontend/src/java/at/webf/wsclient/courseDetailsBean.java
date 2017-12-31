/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Bellacraine
 */
@Named(value = "courseDetailsBean")
//@Dependent
@RequestScoped
public class courseDetailsBean implements Serializable {

    /**
     * Creates a new instance of courseDetailsBean
     */
    private Course course;
    private String username;
    private Integer coursePk;
    private String title;
    private String description;
    private Integer duration;
    private String semester;
    private Integer personPk;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCoursePk() {
        return coursePk;
    }

    public void setCoursePk(Integer coursePk) {
        this.coursePk = coursePk;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getPersonPk() {
        return personPk;
    }

    public void setPersonPk(Integer personPk) {
        this.personPk = personPk;
    }

    public courseDetailsBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        course = (Course) session.getAttribute("course");
        username = (String) session.getAttribute("username");
        personPk = (Integer) session.getAttribute("personPk");

    }

    //--------------------------------------- Container für Username & Passwort
    private InputPayloadCourse parameter1;

    public InputPayloadCourse getParameter1() {
        return parameter1;
    }

    public void setParameter1(InputPayloadCourse parameter1) {
        this.parameter1 = parameter1;
    }

    private InputPayloadPerson parameter2;

    public InputPayloadPerson getParameter2() {
        return parameter2;
    }

    public void setParameter2(InputPayloadPerson parameter2) {
        this.parameter2 = parameter2;
    }

    //---------------------------------------
    public String updateCourse() {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter1 = new InputPayloadCourse();
        parameter2 = new InputPayloadPerson();

        parameter1.setCoursePk(coursePk);
        parameter1.setTitle(title);
        parameter1.setDescription(description);
        parameter1.setDuration(duration);
        parameter1.setSemester(semester);

        parameter2.setPersonPk(personPk);      // Vorbereitung der Daten welche über das WS transportiert werden sollen

        Boolean opl = port.addOrUpdateCourse(parameter1, parameter2); //Der eigentliche Aufruf des WebServices (Synchron)

        return "lecturerCourseList";
    }

//     addOrUpdateCourse
// input: course object ([coursePk], title, description, duration, semester), person.personPk
// on update: give course.coursePk
// on create: leave course.coursePk empty or set null (will be auto increment in db)
// output: true or false
}

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
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tommy
 */
@Named(value = "courseListBean")
@RequestScoped
public class courseListBean implements Serializable {

    private Integer personPk;
    private String username;
    private String role;

    private Course course;
    private ArrayList<Course> courses;

    private Integer grade;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

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

    public Integer getPersonPk() {
        return personPk;
    }

    public void setPersonPk(Integer personPk) {
        this.personPk = personPk;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        personPk = (Integer) session.getAttribute("personPk");
        username = (String) session.getAttribute("username");
        role = (String) session.getAttribute("role");
        loadCourseList();
    }

    //--------------------------------------- Container für Username & Passwort
    private InputPayloadPerson parameter;

    public InputPayloadPerson getParameter() {
        return parameter;
    }

    public void setParameter(InputPayloadPerson parameter) {
        this.parameter = parameter;
    }

    private InputPayloadCourse courseParams;

    public InputPayloadCourse getCourseParams() {
        return courseParams;
    }

    public void setCourseParams(InputPayloadCourse courseParams) {
        this.courseParams = courseParams;
    }

    //---------------------------------------
    private void loadCourseList() { //Login-methode, wird ausgeführt wenn der Button in index.xhtml geklickt wird.

        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter = new InputPayloadPerson();
        parameter.setPersonPk(personPk);      //Vorbereitung der Daten welche über das WS transportiert werden sollen
        parameter.setRole(role);

        OutputPayloadCourse opl = port.loadCourseList(parameter); //Der eigentliche Aufruf des WebServices (Synchron)

        courses = (ArrayList<Course>) opl.getCourses();
    }

    public String showCourseDetails(Course course) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("course", course);
        if (session.getAttribute("role").equals("lecturer")) {
            return "lecturerCourseDetails";
        } else {
            return "courseDetails";
        }
    }

    public void deleteCourse(Course course) {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        courseParams = new InputPayloadCourse();
        courseParams.setCoursePk(course.getCoursePk()); //Vorbereitung der Daten welche über das WS transportiert werden sollen

        Boolean opl = port.deleteCourse(courseParams); //Der eigentliche Aufruf des WebServices (Synchron)
        loadCourseList();
        showMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "Course was deleted successfully.");

    }

    public void showMessage(FacesMessage.Severity severity, String title, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, title, details));
    }

    public void showGrade(Course course) {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter = new InputPayloadPerson();
        courseParams = new InputPayloadCourse();

        parameter.setPersonPk(personPk);      //Vorbereitung der Daten welche über das WS transportiert werden sollen
        courseParams.setCoursePk(course.getCoursePk());
        
        /* message von judith:
         * sorry, dass ich hier reinschreibe (einfach löschen, wenn dus gelesen hast):
         * diese methode ist fürs Frontend nicht mehr verfügbar!
         * die grade und den lecturer gibts jetzt via loadCourseList als course.grade und course.lecturer (wie besprochen)
         * die WebServices sind neu generiert, ich nehme an, das ist deshalb rot unterwellt
         */
        OutputPayloadPersonCourseMembership opl = port.studentGetGrade(courseParams, parameter); //Der eigentliche Aufruf des WebServices (Synchron)

        grade = (Integer) opl.getGrade();
//        loadCourseList();
        // studentGetGrade
        // maybe not needed (if you can deal with the hashset in course object)
        // input: course.coursePk, person.personPk
        // Output: personCourseMembership.grade
    }

    public String showStudentManager(Course course) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("course", course);
        return "lecturerStudentManager";
    }

}

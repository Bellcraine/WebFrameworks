/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bellacraine
 */
@Named(value = "studentManagerBean")
//@SessionScoped
@ViewScoped
public class studentManagerBean implements Serializable {

    /**
     * Creates a new instance of studentManagerBean
     */
    private String username;
    private Course course;
    private List<Person> persons;
    private Person student;
    private Integer grade;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

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

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public studentManagerBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        course = (Course) session.getAttribute("course");
        username = (String) session.getAttribute("username");
        loadStudentList();
    }

    private InputPayloadCourse parameter;

    public InputPayloadCourse getParameter() {
        return parameter;
    }

    public void setParameter(InputPayloadCourse parameter) {
        this.parameter = parameter;
    }

    public void loadStudentList() {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter = new InputPayloadCourse();

        parameter.setCoursePk(course.coursePk);
        // Vorbereitung der Daten welche über das WS transportiert werden sollen

        OutputPayloadPerson opl = port.loadStudentList(parameter); //Der eigentliche Aufruf des WebServices (Synchron)

        persons = opl.getPersons();
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
    public String addStudentToCourse(Person person) {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter1 = new InputPayloadCourse();
        parameter2 = new InputPayloadPerson();

        parameter1.setCoursePk(course.coursePk);
        parameter2.setPersonPk(person.personPk);      // Vorbereitung der Daten welche über das WS transportiert werden sollen

        Boolean opl = port.addPersonToCourse(parameter1, parameter2); //Der eigentliche Aufruf des WebServices (Synchron)
        loadStudentList();
        return "lecturerStudentManager";

//     * addPersonToCourse
//     * input: course.coursePk, person.personPk
//     * output: true / false (returns false if person or course have pks that do not exist in their tables!)
    }

    public String removeStudentFromCourse(Person person) {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter1 = new InputPayloadCourse();
        parameter2 = new InputPayloadPerson();

        parameter1.setCoursePk(course.coursePk);
        parameter2.setPersonPk(person.personPk);      // Vorbereitung der Daten welche über das WS transportiert werden sollen

        Boolean opl = port.deletePersonFromCourse(parameter1, parameter2); //Der eigentliche Aufruf des WebServices (Synchron)
        loadStudentList();
        return "lecturerStudentManager";

//     * deletePersonFromCourse
//     * input: course.coursePk, person.personPk
//     * output: true / false (gives also true, if person-course combination does not exist in membership table -> i will try to fix this)
    }

    public String addGrade() {
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter1 = new InputPayloadCourse();
        parameter2 = new InputPayloadPerson();

        parameter1.setCoursePk(course.coursePk);
        parameter2.setPersonPk(student.personPk);      // Vorbereitung der Daten welche über das WS transportiert werden sollen

        Boolean opl = port.addOrUpdateGrade(parameter1, parameter2, grade); //Der eigentliche Aufruf des WebServices (Synchron)
        
        student = null;
        loadStudentList();
        return "lecturerStudentManager";

//        addOrUpdateGrade Input: course.coursePk, person.personPk, grade (Integer)
//        Output: true / false
    }
}

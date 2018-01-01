/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bellacraine
 */
@Named(value = "courseFormBean")
@RequestScoped
public class courseFormBean {

    /**
     * Creates a new instance of courseFormBean
     */
    private String username;
    private String title;
    private String description;
    private Integer duration;
    private String semester;
    private Integer personPk;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public courseFormBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
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
    public String saveNewCourse() {

        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();

        parameter1 = new InputPayloadCourse();
        parameter2 = new InputPayloadPerson();

        parameter1.setTitle(title);
//        if(parameter1.getTitle().equals("")) {
//            showErrorMessage();
//            return "lecturerCourseForm";
//        }
        parameter1.setDescription(description);
        parameter1.setDuration(duration);
        parameter1.setSemester(semester);

        parameter2.setPersonPk(personPk);     //Vorbereitung der Daten welche über das WS transportiert werden sollen

        Boolean opl = port.addOrUpdateCourse(parameter1, parameter2); //Der eigentliche Aufruf des WebServices (Synchron)

        if (opl == true) {
            showMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "New course was added successfully.");
            return "lecturerCourseList";
        } else {
            showMessage(FacesMessage.SEVERITY_ERROR, "FAILURE", "New course could not be added.");
            return "lecturerCourseForm";
        }
    }

    public void showMessage(FacesMessage.Severity severity, String title, String details) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, title, details));
    }

//    public void refresh() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        String viewId = context.getViewRoot().getViewId();
//        ViewHandler handler = context.getApplication().getViewHandler();
//        UIViewRoot root = handler.createView(context, viewId);
//        root.setViewId(viewId);
//        context.setViewRoot(root);
//    }
}

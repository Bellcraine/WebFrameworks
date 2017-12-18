/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ws;

/**
 *
 * @author Tommy
 */
public class InputPayloadCourse {
    
    private Integer course_pk;
    private String title;
    private String description;
    private Integer duration;
    private String semester;
    
    private Integer person_fk;

    public Integer getPerson_fk() {
        return person_fk;
    }

    public void setPerson_fk(Integer person_fk) {
        this.person_fk = person_fk;
    }

    public Integer getCourse_pk() {
        return course_pk;
    }

    public void setCourse_pk(Integer course_pk) {
        this.course_pk = course_pk;
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

    
    
}

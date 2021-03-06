/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ws.Input;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Tommy
 */
public class InputPayloadCourse {
    
    private Integer coursePk;
    private String title;
    private String description;
    private Integer duration;
    private String semester;
    private Set personCourseMemberships = new HashSet(0);

    public Set getPersonCourseMemberships() {
        return personCourseMemberships;
    }

    public void setPersonCourseMemberships(Set personCourseMemberships) {
        this.personCourseMemberships = personCourseMemberships;
    }


    public Integer getCoursePk() {
        return coursePk;
    }

    public void setCoursePk(Integer coursePk) {
        this.coursePk = coursePk;
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

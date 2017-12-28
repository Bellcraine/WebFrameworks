/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ws.Input;

import at.database.Course;
import at.database.Person;
import at.database.PersonCourseMembershipId;

/**
 *
 * @author Judith
 */
public class InputPayloadPersonCourseMembership {
    
     private PersonCourseMembershipId id;
     private Course course;
     private Person person;
     private Integer grade;

    public PersonCourseMembershipId getId() {
        return id;
    }

    public void setId(PersonCourseMembershipId id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    
}

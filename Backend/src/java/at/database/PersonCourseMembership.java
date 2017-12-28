package at.database;
// Generated 21.12.2017 18:52:49 by Hibernate Tools 4.3.1



/**
 * PersonCourseMembership generated by hbm2java
 */
public class PersonCourseMembership  implements java.io.Serializable {


     private PersonCourseMembershipId id;
     private Course course;
     private Person person;
     private Integer grade;

    public PersonCourseMembership() {
    }

	
    public PersonCourseMembership(PersonCourseMembershipId id, Course course, Person person) {
        this.id = id;
        this.course = course;
        this.person = person;
    }
    public PersonCourseMembership(PersonCourseMembershipId id, Course course, Person person, Integer grade) {
       this.id = id;
       this.course = course;
       this.person = person;
       this.grade = grade;
    }
   
    public PersonCourseMembershipId getId() {
        return this.id;
    }
    
    public void setId(PersonCourseMembershipId id) {
        this.id = id;
    }
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }




}



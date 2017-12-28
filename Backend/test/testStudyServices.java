/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import at.ws.Input.InputPayloadCourse;
import at.ws.Input.InputPayloadPerson;
import at.ws.Output.OutputPayloadCourse;
import at.ws.Output.OutputPayloadPerson;
import at.ws.Output.OutputPayloadPersonCourseMembership;
import at.ws.StudyServices;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Judith
 * testing backend methods
 */
public class testStudyServices {
    StudyServices ss;
    
    @Before
    public void setUp() {
         ss = new StudyServices();
    }
    
    public ExpectedException exception = ExpectedException.none();
	
// tests old login version  
/*    @Test
    public void testLogin() throws Exception {
        Integer expected = 7;
        InputPayloadLogin parameter = new InputPayloadLogin();
        parameter.setPassword("1234");
        parameter.setUsername("urbauer");
        OutputPayloadLogin result = ss.login(parameter);
        assertEquals(expected, result.getUserid());

    } */
    @Test
    public void testLoadPersonDetails() throws Exception {
        String expectedUsername = "judith";
        Integer expectedPersonPk = 9;
        InputPayloadPerson parameter = new InputPayloadPerson();
        parameter.setPersonPk(9);
        OutputPayloadPerson result = ss.loadPersonDetails(parameter);
        assertEquals(expectedUsername, result.getUsername());
        assertEquals(expectedPersonPk, result.getPersonPk());
    }
    
    @Test
    public void testLoadCourseList() throws Exception {
        Integer expectedCoursePk = 7;
        String expectedCourseTitle = "Web Frameworks";
        //Integer expectedGrade = 1;        // inside Hashset -> read via Iterator?
        InputPayloadPerson parameter = new InputPayloadPerson();
        parameter.setPersonPk(7);
        parameter.setRole("student");
        OutputPayloadCourse result = ss.loadCourseList(parameter);
        assertEquals(expectedCoursePk, result.getCourses().get(0).getCoursePk());
        assertEquals(expectedCourseTitle, result.getCourses().get(0).getTitle());

    }
    
/*    @Test
    public void testAddOrUpdateCourse() throws Exception {
        String title = "Web Frameworks";
        String description = "Java Frameworks Hibernate and Primefaces";
        Integer duration = 12;
        String semester = "WS17";
        Integer personPk = 7;
        
        InputPayloadCourse courseParam = new InputPayloadCourse();
        courseParam.setTitle(title);
        courseParam.setDescription(description);
        courseParam.setDuration(duration);
        courseParam.setSemester(semester);
        //courseParam.setCoursePk(7);  // test update
                
        InputPayloadPerson personParam = new InputPayloadPerson();
        personParam.setPersonPk(personPk);
        
        boolean result = ss.addOrUpdateCourse(courseParam, personParam);
        assertEquals(true, result);

    }*/
/*    @Test
    public void testDeleteCourse() throws Exception {
        Integer coursePk = 36;
        InputPayloadCourse parameter = new InputPayloadCourse();
        parameter.setCoursePk(coursePk);
        
        boolean result = ss.deleteCourse(parameter);
        assertEquals(true, result);
    }*/
    
    @Test
    public void testLogin() throws Exception {
        String expectedName = "Judith";
        Integer expectedId = 9;
        String expectedRole = "student";
        InputPayloadPerson parameter = new InputPayloadPerson();
        parameter.setPassword("1234");
        parameter.setUsername("judith");
        OutputPayloadPerson result = ss.login(parameter);
        assertEquals(expectedName, result.getName());
        assertEquals(expectedId, result.getPersonPk());
        assertEquals(expectedRole, result.getRole());
    }
    
    @Test
    public void testStudentGetGrade() throws Exception {
        Integer expectedGrade = 1;
        Integer personPk = 9;  // values to test: tommy+feb(10,8)->exp:1, judith+frameworks(9, 7)->exp: 1, urbauer+frameworks(7, 7)->exp: null
        Integer coursePk = 7;
        InputPayloadPerson personParam = new InputPayloadPerson();
        personParam.setPersonPk(personPk);
        InputPayloadCourse courseParam = new InputPayloadCourse();
        courseParam.setCoursePk(coursePk);
        OutputPayloadPersonCourseMembership result = ss.studentGetGrade(courseParam, personParam);
        assertEquals(expectedGrade, result.getGrade());
    }
        
/*    @Test
    public void testAddPersonToCourse() throws Exception {
        Integer personPk = 13;
        Integer coursePk = 8;
        
        InputPayloadCourse courseParam = new InputPayloadCourse();
        courseParam.setCoursePk(coursePk);
        InputPayloadPerson personParam = new InputPayloadPerson();
        personParam.setPersonPk(personPk);
        
        boolean result = ss.addPersonToCourse(courseParam, personParam);
        assertEquals(true, result);
    }*/

/*    @Test
    public void testDeletePersonFromCourse() throws Exception {
        Integer personPk = 7;
        Integer coursePk = 8;
        
        InputPayloadCourse courseParam = new InputPayloadCourse();
        courseParam.setCoursePk(coursePk);
        InputPayloadPerson personParam = new InputPayloadPerson();
        personParam.setPersonPk(personPk);
        
        boolean result = ss.deletePersonFromCourse(courseParam, personParam);
        assertEquals(true, result);
    }*/
}

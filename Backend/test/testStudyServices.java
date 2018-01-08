/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import at.database.Person;
import at.database.PersonCourseMembership;
import at.ws.Input.InputPayloadCourse;
import at.ws.Input.InputPayloadPerson;
import at.ws.Output.OutputPayloadCourse;
import at.ws.Output.OutputPayloadPerson;
import at.ws.StudyServices;
import java.util.ArrayList;
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
        //String expectedCourseTitle = "Web Frameworks";
        Integer expectedGrade = 2;
        String expectedLecturer = "Philip Urbauer";
        InputPayloadPerson parameter = new InputPayloadPerson();
        parameter.setPersonPk(10);
        parameter.setRole("student");
        OutputPayloadCourse result = ss.loadCourseList(parameter);
        //assertEquals(expectedCoursePk, result.getCourses().get(0).getCoursePk());
        //assertEquals(expectedCourseTitle, result.getCourses().get(0).getTitle());
        //assertEquals(expectedGrade, result.getCourses().get(0).getGrade());
        assertEquals(expectedLecturer, result.getCourses().get(0).getLecturer());

    }
    
/*    @Test
    public void testAddOrUpdateCourse() throws Exception {
        String title = "Backend Basics";
        String description = "all about php";
        Integer duration = 12;
        String semester = "SS17";
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
    } */
    
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
        //Integer expectedId = 9;
        //String expectedRole = "student";
        InputPayloadPerson parameter = new InputPayloadPerson();
        parameter.setPassword("1234");
        parameter.setUsername("judith");
        OutputPayloadPerson result = ss.login(parameter);
        assertEquals(expectedName, result.getName());
        //assertEquals(expectedId, result.getPersonPk());
        //assertEquals(expectedRole, result.getRole());
        //assertEquals(null, result);   // to test result at incorrect login username or password
    }
    
/*  @Test
    public void testLoadMembershipData() throws Exception {
        Integer expectedGrade = 1;
        Integer personPk = 9;  // values to test: tommy+feb(10,8)->exp:1, judith+frameworks(9, 7)->exp: 1, urbauer+frameworks(7, 7)->exp: null
        Integer coursePk = 7;
        InputPayloadPerson personParam = new InputPayloadPerson();
        personParam.setPersonPk(personPk);
        InputPayloadCourse courseParam = new InputPayloadCourse();
        courseParam.setCoursePk(coursePk);
        PersonCourseMembership result = ss.loadMembershipData(courseParam, personParam);
        assertEquals(expectedGrade, result.getGrade());
    }*/
        
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
    
    @Test
    public void testLoadStudentList() throws Exception {
        String expectedUsername = "judith";
        String expectedRole = "student";
        boolean expectedMembership = true;
        Integer expectedGrade = 1;
        InputPayloadCourse courseParam = new InputPayloadCourse();
        courseParam.setCoursePk(7); // frameworks
        OutputPayloadPerson result = ss.loadStudentList(courseParam);
        assertEquals(expectedUsername, result.getPersons().get(0).getUsername());  // first student object -> judith
        assertEquals(expectedRole, result.getPersons().get(0).getRole());
        assertEquals(expectedMembership, result.getPersons().get(0).isMembership());
        assertEquals(expectedGrade, result.getPersons().get(0).getGrade());
    }
    
    /*@Test
    public void testGetAllStudents() throws Exception {
        Integer expectedPersonPk = 10;  // tom
        ArrayList<Person> result = ss.getAllStudents();
        assertEquals(expectedPersonPk, result.get(1).getPersonPk());
    }*/
    
    /*@Test
    public void testAddOrUpdateGrade() throws Exception {
        boolean expected = true;
        InputPayloadCourse courseParam = new InputPayloadCourse();
        courseParam.setCoursePk(7); // Frontend
        InputPayloadPerson personParam = new InputPayloadPerson();
        personParam.setPersonPk(10); // tommy
        Integer grade = 1;
        boolean result = ss.addOrUpdateGrade(courseParam, personParam, grade);
        assertEquals(expected, result);     
    } */
    
    /*@Test
    public void testAddOrUpdatePerson() throws Exception {
        boolean expected = true;
        InputPayloadPerson personParam = new InputPayloadPerson();
        //personParam.setPersonPk(10); // tommy
        personParam.setUsername("tom");
        personParam.setLastname("Brandstätter");
        personParam.setName("Thomas");
        personParam.setRole("student");
        //personParam.setPassword("12345");
        boolean result = ss.addOrUpdatePerson(personParam);
        assertEquals(expected, result);     
    }*/
    
    /*@Test
    public void testGetLecturer() throws Exception {
        String expected = "Florian Eckkrammer";
        InputPayloadCourse parameter = new InputPayloadCourse();
        parameter.setCoursePk(8);
        String result = ss.getLecturer(parameter);
        assertEquals(expected, result);     
    }*/
    
}

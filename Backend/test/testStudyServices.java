/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import at.ws.InputPayloadLogin;
import at.ws.OutputPayloadLogin;
import at.ws.InputPayloadPerson;
import at.ws.OutputPayloadPerson;
import at.ws.StudyServices;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Judith
 * not working
 */
public class testStudyServices {
    StudyServices ss;
    
    @Before
    public void setUp() {
         ss = new StudyServices();
    }
    
    public ExpectedException exception = ExpectedException.none();
	
    
    @Test
    public void testLogin() throws Exception {
        Integer expected = 7;
        InputPayloadLogin parameter = new InputPayloadLogin();
        parameter.setPassword("1234");
        parameter.setUsername("urbauer");
        OutputPayloadLogin result = ss.login(parameter);
        assertEquals(expected, result.getUserid(), 0.1);

    }
    @Test
    public void testShowPersonData() throws Exception {
        String expected = "Ecki";
        InputPayloadPerson parameter = new InputPayloadPerson();
        parameter.setPersonPk(8);
        OutputPayloadPerson result = ss.showPersonData(parameter);
        assertEquals(expected, result.getUsername(), 0.1);
        
    }
}

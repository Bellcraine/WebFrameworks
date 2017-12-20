/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ws;

import at.database.Course;
import at.database.HibernateUtil;
import at.database.Person;
import at.database.PersonCourseMembership;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Judith
 */
@WebService(serviceName = "StudyServices")
public class StudyServices {

    /**
     * login
     * input: person.username, person.password
     * output: person object
     */
    @WebMethod(operationName = "login")
    public OutputPayloadPerson login(@WebParam(name = "parameter") InputPayloadPerson parameter) {

        OutputPayloadPerson opl = new OutputPayloadPerson();

        //Hibernate 
        SessionFactory sf = HibernateUtil.getSessionFactory();  //Initialisierung der SessionFactory
        Session s = sf.openSession();                           //Öffne eine Session 
        Transaction tx = null;

        try {

            tx = s.beginTransaction();                          //Beginne Transaktion
            String hql = "FROM Person P WHERE P.username = :name";  //HQL Query um Person zu suchen
            Query query = s.createQuery(hql);                   //HQL Query zuweisen
            query.setParameter("name", parameter.getUsername()); //Wert für den namen einfügen (gegen SQL Injection!)
            List results = query.list();                        //Abfrage durchführen

            Person personFromDb = (Person) results.get(0);       //Resultat in person casten

            if (personFromDb.getPassword().equals(parameter.getPassword())) {             //Überprüfen des Passworts und entsprechend Response mit Sccuess/Failure info befüllen
                opl.setPersonPk(personFromDb.getPersonPk());
                opl.setRole(personFromDb.getRole());
                opl.setUsername(personFromDb.getUsername());
                opl.setName(personFromDb.getName());
                opl.setLastname(personFromDb.getLastname());

            }

            tx.commit();            //Transaktion durchführen
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();      //Bei Fehlerfall => Rollback!
            }
        } finally {
            s.close();              //Session schließen egal ob Erfolg oder Fehler
        }

        //Hibernate
        return opl;
    }

    /**
     * Web getCourses
     * get all Couses regardless of users id (old version, do not use anymore)
     */
    @WebMethod(operationName = "getCourses")
    public OutputPayloadCourse getCourses() {

        OutputPayloadCourse opl = new OutputPayloadCourse();

        //Hibernate 
        SessionFactory sf = HibernateUtil.getSessionFactory();  //Initialisierung der SessionFactory
        Session s = sf.openSession();                           //Öffne eine Session 
        Transaction tx = null;

        try {

            tx = s.beginTransaction();                          //Beginne Transaktion
            String hql = "FROM Course";                         //HQL Query um Person zu suchen
            Query query = s.createQuery(hql);                   //HQL Query zuweisen
            // query.setParameter("name", parameter.getUsername()); //Wert für den namen einfügen (gegen SQL Injection!)
            List results = query.list();                        //Abfrage durchführen

            for (int i = 0; i < results.size(); i++) {
                
            
            Course courseFromDb = (Course) results.get(i);   //Resultat in person casten
            
            Course c = new Course();
               c.setCoursePk(courseFromDb.getCoursePk());
               c.setTitle(courseFromDb.getTitle());
               c.setDescription(courseFromDb.getDescription()); 
               
               opl.addCourse(c);
            }
            tx.commit();            //Transaktion durchführen
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();      //Bei Fehlerfall => Rollback!
            }
        } finally {
            s.close();              //Session schließen egal ob Erfolg oder Fehler
        }

        //Hibernate
        return opl;
    }

    /**
     * loadCourseList (for students and lecturers)
     * input: person.personPk, person.role
     * output: course ArrayList // [students: with personCourseMembership.grade]
     */
    @WebMethod(operationName = "loadCourseList")
    public OutputPayloadCourse loadCourseList(@WebParam(name = "parameter") InputPayloadPerson parameter) {

        OutputPayloadCourse opl = new OutputPayloadCourse();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        try {

            tx = s.beginTransaction();
            // change query / add new query to get M.grade
            String hql = "SELECT C FROM PersonCourseMembership M LEFT JOIN M.course C WHERE M.person.personPk = :id";
            Query query = s.createQuery(hql);
            query.setParameter("id", parameter.getPersonPk());
            List results = query.list();

           for (int i = 0; i < results.size(); i++) {
                
                Course courseFromDb = (Course) results.get(i);

                Course c = new Course();
                   c.setCoursePk(courseFromDb.getCoursePk());
                   c.setTitle(courseFromDb.getTitle());
                   c.setDescription(courseFromDb.getDescription());
                   c.setDuration(courseFromDb.getDuration());
                   c.setSemester(courseFromDb.getSemester());
                   /*if (parameter.getRole().equalsIgnoreCase("student")) {
                   // setGrade
                   } */
                   opl.addCourse(c);
            }

            tx.commit();
        
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            s.close();
        }

        return opl;
    }

    /**
     * loadPersonDetails
     * input: person.personPk
     * output: person Object
     */
    @WebMethod(operationName = "loadPersonDetails")
    public OutputPayloadPerson loadPersonDetails(@WebParam(name = "parameter") InputPayloadPerson parameter) {
        
        OutputPayloadPerson opl = new OutputPayloadPerson();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession(); 
        Transaction tx = null;

        try {

            tx = s.beginTransaction();
            String hql = "FROM Person P WHERE P.personPk = :id";
            Query query = s.createQuery(hql);
            query.setParameter("id", parameter.getPersonPk());
            List results = query.list();
                
            Person personFromDb = (Person) results.get(0);
            opl.setPersonPk(personFromDb.getPersonPk());
            opl.setUsername(personFromDb.getUsername());
            opl.setPassword(personFromDb.getPassword());
            opl.setName(personFromDb.getName());
            opl.setLastname(personFromDb.getLastname());
            opl.setRole(personFromDb.getRole());
            
            tx.commit();
        
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            s.close();
        }

        return opl;  
    }
    
    /**
     * loadCourseDetails
     * input: course.coursePk
     * output: course object
     */
    @WebMethod(operationName = "loadCourseDetails")
    public OutputPayloadCourse loadCourseDetails(@WebParam(name = "parameter") InputPayloadCourse parameter) {
        
        OutputPayloadCourse opl = new OutputPayloadCourse();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession(); 
        Transaction tx = null;
        
        try {
            tx = s.beginTransaction();  
            String hql= "FROM Course C WHERE C.coursePk = :id";
            Query query = s.createQuery(hql);                   //HQL Query zuweisen
            query.setParameter("id", parameter.getCoursePk());                    //Wert für die id einfügen (gegen SQL Injection!)
            List results = query.list();

            Course courseFromDb = (Course) results.get(0);
            opl.setCoursePk(courseFromDb.getCoursePk());
            opl.setTitle(courseFromDb.getTitle());
            opl.setDescription(courseFromDb.getDescription());
            opl.setDuration(courseFromDb.getDuration());
            opl.setSemester(courseFromDb.getSemester());
            
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            
        } finally {
            s.close();
        }
        return opl;
    }

    /**
     * addOrUpdateCourse
     * input: course object (title, description, duration, semester), person.personPk
     * output: true or false
     */
    @WebMethod(operationName = "addOrUpdateCourse")
    public boolean addOrUpdateCourse (@WebParam(name = "courseParam") InputPayloadCourse courseParam, @WebParam(name = "personParam") InputPayloadPerson personParam) {
        
        boolean done = false;
        OutputPayloadCourse opl = new OutputPayloadCourse();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;
        
        Course c = new Course();
        c.setTitle(courseParam.getTitle());
        c.setDescription(courseParam.getDescription());
        c.setDuration(courseParam.getDuration());
        c.setSemester(courseParam.getSemester());
        
        Person p = new Person();
        p.setPersonPk(personParam.getPersonPk());
        
        PersonCourseMembership m = new PersonCourseMembership();
        m.setCourse(c);
        m.setPerson(p);
 
        try {
            
           // this works for just the course table
           tx = s.beginTransaction();
            if (courseParam.getCoursePk() != null) {
                c.setCoursePk(courseParam.getCoursePk());
            }
            s.saveOrUpdate(c);
            tx.commit();
            
           // this does not work
            /*tx = s.beginTransaction();
            s.saveOrUpdate(m);
            tx.commit();*/
            
            done = true;

                   
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
                done = false;
            }
            
        } finally {
            s.close();
        }
        
        return done;
    }

    /**
     * deleteCourse
     * input: course.coursePk
     * Output: true or false
     */
    @WebMethod(operationName = "deleteCourse")
    public Boolean deleteCourse(@WebParam(name = "parameter") InputPayloadCourse parameter) {
        
        boolean done = false;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;
        
        Course c = new Course();
        c.setCoursePk(parameter.getCoursePk());
        
        try {

            tx = s.beginTransaction();
            s.delete(c);
            tx.commit();
            done = true;
                   
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
                done = false;
            }
            
        } finally {
            s.close();
        }
         
        return done;
        
    }
    
}

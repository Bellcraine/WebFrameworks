/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ws;

import at.ws.Output.OutputPayloadPerson;
import at.ws.Output.OutputPayloadCourse;
import at.ws.Input.InputPayloadPerson;
import at.ws.Input.InputPayloadCourse;
import at.database.Course;
import at.database.HibernateUtil;
import at.database.Person;
import at.database.PersonCourseMembership;
import at.database.PersonCourseMembershipId;
import java.util.ArrayList;
import java.util.List;
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
     * login input: person.username, person.password output: person object OR
     * null if login is incorrect
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
            } else {
//                opl = null; // funktioniert so nicht 
                opl.setPersonPk(null);
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
     * loadCourseList (for students and lecturers) input: person.personPk,
     * person.role output: course ArrayList --- only students have grade &
     * lecturer
     */
    @WebMethod(operationName = "loadCourseList")
    public OutputPayloadCourse loadCourseList(@WebParam(name = "parameter") InputPayloadPerson parameter) {

        OutputPayloadCourse opl = new OutputPayloadCourse();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        try {

            tx = s.beginTransaction();
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

                if (parameter.getRole().equals("student")) {
                    InputPayloadCourse ipl = new InputPayloadCourse();
                    ipl.setCoursePk(c.getCoursePk());

                    // get grade
                    PersonCourseMembership m = loadMembershipData(ipl, parameter);
                    c.setGrade(m.getGrade());

                    // get lecturer
                    String lecturer = getLecturer(ipl);
                    c.setLecturer(lecturer);
                }
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
     * loadPersonDetails input: person.personPk output: person Object
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
     * loadCourseDetails input: course.coursePk output: course object not
     * needed!
     */
    /*@WebMethod(operationName = "loadCourseDetails")
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
            tx.commit();
            
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            
        } finally {
            s.close();
        }
        return opl;
    } */
    /**
     * addOrUpdateCourse input: course object ([coursePk], title, description,
     * duration, semester), person.personPk on update: give course.coursePk on
     * create: leave course.coursePk empty or set null (will be auto increment
     * in db) output: true or false
     */
    @WebMethod(operationName = "addOrUpdateCourse")
    public Boolean addOrUpdateCourse(@WebParam(name = "courseParam") InputPayloadCourse courseParam, @WebParam(name = "personParam") InputPayloadPerson personParam) {

        boolean done = false;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

//        if (courseParam.getTitle() != null) {
        if (!courseParam.getTitle().equals("")) { // <---- TOMMY changed: er testet jetzt auf leeren string, nicht mehr auf null.

            Course c = new Course();
            c.setTitle(courseParam.getTitle());
            c.setDescription(courseParam.getDescription());
            c.setDuration(courseParam.getDuration());
            c.setSemester(courseParam.getSemester());
            c.setPersonCourseMemberships(courseParam.getPersonCourseMemberships());

            Person p = new Person();
            p.setPersonPk(personParam.getPersonPk());

            try {

                tx = s.beginTransaction();
                if (courseParam.getCoursePk() != null) {
                    c.setCoursePk(courseParam.getCoursePk());
                }
                s.saveOrUpdate(c);
                tx.commit();

                PersonCourseMembershipId id = new PersonCourseMembershipId();
                id.setCourseFk(c.getCoursePk());
                id.setPersonFk(personParam.getPersonPk());

                PersonCourseMembership m = new PersonCourseMembership();
                m.setId(id);
                m.setCourse(c);
                m.setPerson(p);

                tx = s.beginTransaction();
                s.saveOrUpdate(m);
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
        } else {
            done = false;
        }
        return done;
    }

    /**
     * deleteCourse input: course.coursePk Output: true or false
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

    /**
     * addPersonToCourse input: course.coursePk, person.personPk output: true /
     * false (returns false if person or course have pks that do not exist in
     * their tables!)
     */
    @WebMethod(operationName = "addPersonToCourse")
    public Boolean addPersonToCourse(@WebParam(name = "courseParam") InputPayloadCourse courseParam, @WebParam(name = "personParam") InputPayloadPerson personParam) {

        boolean done = false;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        Course c = new Course();
        c.setCoursePk(courseParam.getCoursePk());

        Person p = new Person();
        p.setPersonPk(personParam.getPersonPk());

        PersonCourseMembershipId mid = new PersonCourseMembershipId();
        mid.setCourseFk(courseParam.getCoursePk());
        mid.setPersonFk(personParam.getPersonPk());

        PersonCourseMembership m = new PersonCourseMembership();
        m.setId(mid);
        m.setCourse(c);
        m.setPerson(p);

        try {

            tx = s.beginTransaction();
            s.saveOrUpdate(m);  // saves new combination, does not add same combination
            tx.commit();
            done = true;

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
                done = false;   // returns false, if neither personPk or coursePk exist
            }

        } finally {
            s.close();
        }

        return done;
    }

    /**
     * deletePersonFromCourse input: course.coursePk, person.personPk output:
     * true / false (gives also true, if person-course combination does not
     * exist in membership table)
     */
    @WebMethod(operationName = "deletePersonFromCourse")
    public Boolean deletePersonFromCourse(@WebParam(name = "courseParam") InputPayloadCourse courseParam, @WebParam(name = "personParam") InputPayloadPerson personParam) {

        boolean done = false;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        Course c = new Course();
        c.setCoursePk(courseParam.getCoursePk());

        Person p = new Person();
        p.setPersonPk(personParam.getPersonPk());

        PersonCourseMembershipId mid = new PersonCourseMembershipId();
        mid.setCourseFk(courseParam.getCoursePk());
        mid.setPersonFk(personParam.getPersonPk());

        PersonCourseMembership m = new PersonCourseMembership();
        m.setId(mid);
        m.setCourse(c);
        m.setPerson(p);

        try {

            tx = s.beginTransaction();
            //s.delete(m);
            /*String hql= "DELETE PersonCourseMembership M WHERE M.course.coursePk = :cid AND M.person.personPk = :pid";
            Query query = s.createQuery(hql);                   //HQL Query zuweisen
            query.setParameter("cid", courseParam.getCoursePk());
            query.setParameter("pid", personParam.getPersonPk());
            List results = query.list();
            if (results.size() == 1) {
                done = true;
            } */
            s.delete(m);
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

    /**
     * loadStudentList input: course.coursePk output: person ArrayList (only
     * students) -> isMembership returns true / false, if student is member of
     * given course
     */
    @WebMethod(operationName = "loadStudentList")
    public OutputPayloadPerson loadStudentList(@WebParam(name = "parameter") InputPayloadCourse parameter) {

        OutputPayloadPerson opl = new OutputPayloadPerson();
        ArrayList<Person> students = getAllStudents();

        for (int i = 0; i < students.size(); i++) {

            Person p = students.get(i);
            InputPayloadPerson ipl = new InputPayloadPerson();
            ipl.setPersonPk(p.getPersonPk());

            PersonCourseMembership m = loadMembershipData(parameter, ipl);
            if (m.getPerson() == null) {
                p.setMembership(false);
            } else {
                p.setMembership(true);
            }
            p.setGrade(m.getGrade());
            opl.addPerson(p);

        }

        return opl;
    }

    /**
     * addOrUpdateGrade Input: course.coursePk, person.personPk, grade (Integer)
     * Output: true / false
     */
    @WebMethod(operationName = "addOrUpdateGrade")
    public Boolean addOrUpdateGrade(@WebParam(name = "courseParam") InputPayloadCourse courseParam, @WebParam(name = "personParam") InputPayloadPerson personParam, @WebParam(name = "grade") Integer grade) {

        boolean done = false;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        Course c = new Course();
        c.setCoursePk(courseParam.getCoursePk());

        Person p = new Person();
        p.setPersonPk(personParam.getPersonPk());

        PersonCourseMembershipId id = new PersonCourseMembershipId();
        id.setCourseFk(c.getCoursePk());
        id.setPersonFk(p.getPersonPk());

        PersonCourseMembership m = new PersonCourseMembership();
        m.setId(id);
        m.setCourse(c);
        m.setPerson(p);
        m.setGrade(grade);

        try {

            tx = s.beginTransaction();
            s.saveOrUpdate(m);
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

    /**
     * addOrUpdatePerson input: person (all parameters exept password and pk
     * (both optional)) case 1 no primary key / with password -> person will be
     * created (password required!) case 2 with primary key / no password ->
     * person will be updated (password stays the same) case 3 with primary key
     * / with password -> person will be updated completely output: true / false
     */
    @WebMethod(operationName = "addOrUpdatePerson")
    public Boolean addOrUpdatePerson(@WebParam(name = "parameter") InputPayloadPerson parameter) {

        boolean done = false;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        // person needs to have all params (exept pk) to add or update
        Person p = new Person();
        p.setLastname(parameter.getLastname());
        p.setName(parameter.getName());
        p.setUsername(parameter.getUsername());
        p.setRole(parameter.getRole());

        // password needs to be set -> get stored password from db to have password parameter in p
//        if (parameter.getPassword() != null) {  
        if (!parameter.getPassword().equals("")) { // <---- TOMMY changed: er testet jetzt auf leeren string, nicht mehr auf null.
            p.setPassword(parameter.getPassword());
        } else {
            OutputPayloadPerson opl = loadPersonDetails(parameter);
            p.setPassword(opl.getPassword());
        }

        try {

            tx = s.beginTransaction();
            if (parameter.getPersonPk() != null) {
                p.setPersonPk(parameter.getPersonPk());
            }
            s.saveOrUpdate(p);
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

    /**
     * ************************************
     * methods for backend use only
     *************************************
     */
    /**
     * FOR BACKEND USE ONLY loadMembershipData (previous: studentGetGrade)
     * input: course.coursePk, person.personPk Output: personCourseMembership
     * (all parameters) turn public to test
     */
    private PersonCourseMembership loadMembershipData(@WebParam(name = "courseParam") InputPayloadCourse courseParam, @WebParam(name = "personParam") InputPayloadPerson personParam) {

        //OutputPayloadPersonCourseMembership opl = new OutputPayloadPersonCourseMembership();
        PersonCourseMembership membership = new PersonCourseMembership();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        try {

            tx = s.beginTransaction();
            String hql = "FROM PersonCourseMembership M WHERE M.course.coursePk = :cid AND M.person.personPk = :pid";
            Query query = s.createQuery(hql);                   //HQL Query zuweisen
            query.setParameter("cid", courseParam.getCoursePk());                    //Wert für die id einfügen (gegen SQL Injection!)
            query.setParameter("pid", personParam.getPersonPk());
            List results = query.list();

            membership = (PersonCourseMembership) results.get(0);

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {
            s.close();
        }

        return membership;
    }

    /**
     * FOR BACKEND USE ONLY getAllStudents input: none output: ArrayList of
     * Persons turn public to test
     */
    private ArrayList<Person> getAllStudents() {

        ArrayList<Person> students = new ArrayList<>();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            String hql = "FROM Person P WHERE P.role = :role";
            Query query = s.createQuery(hql);
            query.setParameter("role", "student");
            List results = query.list();

            for (int i = 0; i < results.size(); i++) {

                Person personFromDb = (Person) results.get(i);
                Person p = new Person();
                p.setPersonPk(personFromDb.getPersonPk());
                p.setLastname(personFromDb.getLastname());
                p.setName(personFromDb.getName());
                p.setRole(personFromDb.getRole());
                p.setUsername(personFromDb.getUsername());
                students.add(p);
            }
            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            s.close();
        }

        return students;
    }

    /**
     * FOR BACKEND USE ONLY getLecturer input: course.coursePk ouput: String
     * containing first and last name of lecturer turn public to test
     */
    private String getLecturer(@WebParam(name = "parameter") InputPayloadCourse parameter) {

        String lecturer = null;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = null;

        try {

            tx = s.beginTransaction();
            String hql = "SELECT P FROM PersonCourseMembership M LEFT JOIN M.person P WHERE M.course.coursePk = :id AND M.person.role = :role";
            Query query = s.createQuery(hql);
            query.setParameter("id", parameter.getCoursePk());
            query.setParameter("role", "lecturer");

            List results = query.list();
            Person personFromDb = (Person) results.get(0);
            lecturer = personFromDb.getName() + " " + personFromDb.getLastname();

            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            s.close();
        }

        return lecturer;
    }

}

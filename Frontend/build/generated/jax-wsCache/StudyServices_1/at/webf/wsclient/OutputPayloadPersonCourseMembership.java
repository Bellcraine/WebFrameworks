
package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für outputPayloadPersonCourseMembership complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="outputPayloadPersonCourseMembership">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="course" type="{http://ws.at/}course" minOccurs="0"/>
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="id" type="{http://ws.at/}personCourseMembershipId" minOccurs="0"/>
 *         &lt;element name="person" type="{http://ws.at/}person" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outputPayloadPersonCourseMembership", propOrder = {
    "course",
    "grade",
    "id",
    "person"
})
public class OutputPayloadPersonCourseMembership {

    protected Course course;
    protected Integer grade;
    protected PersonCourseMembershipId id;
    protected Person person;

    /**
     * Ruft den Wert der course-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Course }
     *     
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Legt den Wert der course-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Course }
     *     
     */
    public void setCourse(Course value) {
        this.course = value;
    }

    /**
     * Ruft den Wert der grade-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * Legt den Wert der grade-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGrade(Integer value) {
        this.grade = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PersonCourseMembershipId }
     *     
     */
    public PersonCourseMembershipId getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonCourseMembershipId }
     *     
     */
    public void setId(PersonCourseMembershipId value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der person-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Legt den Wert der person-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

}

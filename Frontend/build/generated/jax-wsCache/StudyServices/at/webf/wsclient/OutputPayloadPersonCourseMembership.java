
package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for outputPayloadPersonCourseMembership complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="outputPayloadPersonCourseMembership"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="course" type="{http://ws.at/}course" minOccurs="0"/&gt;
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://ws.at/}personCourseMembershipId" minOccurs="0"/&gt;
 *         &lt;element name="person" type="{http://ws.at/}person" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * Gets the value of the course property.
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
     * Sets the value of the course property.
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
     * Gets the value of the grade property.
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
     * Sets the value of the grade property.
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
     * Gets the value of the id property.
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
     * Sets the value of the id property.
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
     * Gets the value of the person property.
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
     * Sets the value of the person property.
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


package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personCourseMembershipId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personCourseMembershipId"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="courseFk" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="personFk" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personCourseMembershipId", propOrder = {
    "courseFk",
    "personFk"
})
public class PersonCourseMembershipId {

    protected int courseFk;
    protected int personFk;

    /**
     * Gets the value of the courseFk property.
     * 
     */
    public int getCourseFk() {
        return courseFk;
    }

    /**
     * Sets the value of the courseFk property.
     * 
     */
    public void setCourseFk(int value) {
        this.courseFk = value;
    }

    /**
     * Gets the value of the personFk property.
     * 
     */
    public int getPersonFk() {
        return personFk;
    }

    /**
     * Sets the value of the personFk property.
     * 
     */
    public void setPersonFk(int value) {
        this.personFk = value;
    }

}

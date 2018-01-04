
package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addOrUpdateGrade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addOrUpdateGrade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="courseParam" type="{http://ws.at/}inputPayloadCourse" minOccurs="0"/&gt;
 *         &lt;element name="personParam" type="{http://ws.at/}inputPayloadPerson" minOccurs="0"/&gt;
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addOrUpdateGrade", propOrder = {
    "courseParam",
    "personParam",
    "grade"
})
public class AddOrUpdateGrade {

    protected InputPayloadCourse courseParam;
    protected InputPayloadPerson personParam;
    protected Integer grade;

    /**
     * Gets the value of the courseParam property.
     * 
     * @return
     *     possible object is
     *     {@link InputPayloadCourse }
     *     
     */
    public InputPayloadCourse getCourseParam() {
        return courseParam;
    }

    /**
     * Sets the value of the courseParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputPayloadCourse }
     *     
     */
    public void setCourseParam(InputPayloadCourse value) {
        this.courseParam = value;
    }

    /**
     * Gets the value of the personParam property.
     * 
     * @return
     *     possible object is
     *     {@link InputPayloadPerson }
     *     
     */
    public InputPayloadPerson getPersonParam() {
        return personParam;
    }

    /**
     * Sets the value of the personParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputPayloadPerson }
     *     
     */
    public void setPersonParam(InputPayloadPerson value) {
        this.personParam = value;
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

}

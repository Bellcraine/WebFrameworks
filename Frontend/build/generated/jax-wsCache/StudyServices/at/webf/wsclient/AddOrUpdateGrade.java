
package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für addOrUpdateGrade complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="addOrUpdateGrade">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="courseParam" type="{http://ws.at/}inputPayloadCourse" minOccurs="0"/>
 *         &lt;element name="personParam" type="{http://ws.at/}inputPayloadPerson" minOccurs="0"/>
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Ruft den Wert der courseParam-Eigenschaft ab.
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
     * Legt den Wert der courseParam-Eigenschaft fest.
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
     * Ruft den Wert der personParam-Eigenschaft ab.
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
     * Legt den Wert der personParam-Eigenschaft fest.
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

}

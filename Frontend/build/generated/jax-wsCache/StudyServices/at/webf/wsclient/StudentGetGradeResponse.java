
package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentGetGradeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentGetGradeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://ws.at/}outputPayloadPersonCourseMembership" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentGetGradeResponse", propOrder = {
    "_return"
})
public class StudentGetGradeResponse {

    @XmlElement(name = "return")
    protected OutputPayloadPersonCourseMembership _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link OutputPayloadPersonCourseMembership }
     *     
     */
    public OutputPayloadPersonCourseMembership getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputPayloadPersonCourseMembership }
     *     
     */
    public void setReturn(OutputPayloadPersonCourseMembership value) {
        this._return = value;
    }

}

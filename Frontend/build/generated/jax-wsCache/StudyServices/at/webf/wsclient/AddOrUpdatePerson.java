
package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addOrUpdatePerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addOrUpdatePerson"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parameter" type="{http://ws.at/}inputPayloadPerson" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addOrUpdatePerson", propOrder = {
    "parameter"
})
public class AddOrUpdatePerson {

    protected InputPayloadPerson parameter;

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link InputPayloadPerson }
     *     
     */
    public InputPayloadPerson getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputPayloadPerson }
     *     
     */
    public void setParameter(InputPayloadPerson value) {
        this.parameter = value;
    }

}

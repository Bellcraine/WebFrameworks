
package at.webf.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für outputPayloadLogin complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="outputPayloadLogin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fehlerbeschreibung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fehlercode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outputPayloadLogin", propOrder = {
    "fehlerbeschreibung",
    "fehlercode",
    "role",
    "userid"
})
public class OutputPayloadLogin {

    protected String fehlerbeschreibung;
    protected Integer fehlercode;
    protected String role;
    protected Integer userid;

    /**
     * Ruft den Wert der fehlerbeschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFehlerbeschreibung() {
        return fehlerbeschreibung;
    }

    /**
     * Legt den Wert der fehlerbeschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFehlerbeschreibung(String value) {
        this.fehlerbeschreibung = value;
    }

    /**
     * Ruft den Wert der fehlercode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFehlercode() {
        return fehlercode;
    }

    /**
     * Legt den Wert der fehlercode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFehlercode(Integer value) {
        this.fehlercode = value;
    }

    /**
     * Ruft den Wert der role-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Legt den Wert der role-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Ruft den Wert der userid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * Legt den Wert der userid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserid(Integer value) {
        this.userid = value;
    }

}

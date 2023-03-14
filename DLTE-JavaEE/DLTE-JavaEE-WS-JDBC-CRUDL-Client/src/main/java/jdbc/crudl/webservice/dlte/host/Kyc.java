
package host;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for kyc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kyc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aadhaar" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="acc_bal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="acc_holder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acc_number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contact" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kyc", propOrder = {
    "aadhaar",
    "accBal",
    "accHolder",
    "accNumber",
    "address",
    "contact",
    "email",
    "pan",
    "passcode"
})
public class Kyc {

    protected long aadhaar;
    @XmlElement(name = "acc_bal")
    protected double accBal;
    @XmlElement(name = "acc_holder")
    protected String accHolder;
    @XmlElement(name = "acc_number")
    protected int accNumber;
    protected String address;
    protected long contact;
    protected String email;
    protected String pan;
    protected String passcode;

    /**
     * Gets the value of the aadhaar property.
     * 
     */
    public long getAadhaar() {
        return aadhaar;
    }

    /**
     * Sets the value of the aadhaar property.
     * 
     */
    public void setAadhaar(long value) {
        this.aadhaar = value;
    }

    /**
     * Gets the value of the accBal property.
     * 
     */
    public double getAccBal() {
        return accBal;
    }

    /**
     * Sets the value of the accBal property.
     * 
     */
    public void setAccBal(double value) {
        this.accBal = value;
    }

    /**
     * Gets the value of the accHolder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccHolder() {
        return accHolder;
    }

    /**
     * Sets the value of the accHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccHolder(String value) {
        this.accHolder = value;
    }

    /**
     * Gets the value of the accNumber property.
     * 
     */
    public int getAccNumber() {
        return accNumber;
    }

    /**
     * Sets the value of the accNumber property.
     * 
     */
    public void setAccNumber(int value) {
        this.accNumber = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     */
    public long getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     */
    public void setContact(long value) {
        this.contact = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPan() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPan(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the passcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasscode() {
        return passcode;
    }

    /**
     * Sets the value of the passcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasscode(String value) {
        this.passcode = value;
    }

}

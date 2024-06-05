package com.nirajaky.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Employee")
public class Employee {

    private String empID;
    private String firstName;
    @JsonIgnore
    private String lastName;
    private String emailID;

    /*
        This @JsonIgnore annotation is used when we want any specific fields or attributes of POJO class
        to de discarded during serialization and deserialization by Jackson.

        We can use @JsonIgnoreProperties({"field1", "filed2"})
        to Ignore multiple fields
    */
    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

}

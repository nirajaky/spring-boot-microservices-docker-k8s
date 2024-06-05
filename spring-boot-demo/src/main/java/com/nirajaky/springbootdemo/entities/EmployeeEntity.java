package com.nirajaky.springbootdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class EmployeeEntity {

    @Id
    private String empID;
    private String firstName;
    @JsonIgnore
    private String lastName;
    private String emailID;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String empID, String firstName, String lastName, String emailID) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
    }

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

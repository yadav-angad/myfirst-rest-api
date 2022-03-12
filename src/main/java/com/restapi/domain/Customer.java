package com.restapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String emailId, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "EMAIL_ADDRESS", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "ADDRESS", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
                + "]";
    }

}
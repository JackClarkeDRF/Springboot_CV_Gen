package org.example.model;

import javax.persistence.*;

/**
 * This Class holds the BasicInfo object. It relates to the basic_info table in the database schema 'ResumeDatabase'.
 * The Object hold the name,email,phone number and clearance level of an individual.
 *
 * The Primary Key of this schema is the email.
 */

@Entity
@Table(name = "basic_info")
public class BasicInfo {

    @Column(name = "name")
    private String applicantName;

    @Id
    @Column(name = "email")
    private String applicantEmail;

    @Column(name = "phone_number")
    private String applicantPhoneNumber;

    @Column(name = "clearance")
    private String applicantClearanceLevel;


    public BasicInfo(String name, String email, String phone, String clearance) {

        this.applicantName = name;
        this.applicantEmail = email;
        this.applicantPhoneNumber = phone;
        this.applicantClearanceLevel = clearance;
    }

    public BasicInfo() {

    }

    public String getName() {
        return applicantName;
    }

    public void setName(String name) {
        this.applicantName = name;
    }

    public String getEmail() {
        return applicantEmail;
    }

    public void setEmail(String email) {
        this.applicantEmail = email;
    }

    public String getPhone() {
        return applicantPhoneNumber;
    }

    public void setPhone(String phone) {
        this.applicantPhoneNumber = phone;
    }

    public String getClearance() {
        return applicantClearanceLevel;
    }

    public void setClearance(String clearance) {
        this.applicantClearanceLevel = clearance;
    }


}

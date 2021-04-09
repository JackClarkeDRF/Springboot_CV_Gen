package org.example.model;

import javax.persistence.*;

/**
 * This Class holds the CertOrAward Object. It relates to the cert_or_award table in the database schema 'ResumeDatabase'.
 * The Object hold an email and a description of the certification or Award.
 *
 * The Primary Key of this schema is the email.
 */

@Entity
@Table(name = "cert_or_award")
public class CertOrAward {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String applicantJobAwards;


    public CertOrAward(){

    }

    public CertOrAward(String applicantJobAwards){
        this.applicantJobAwards = applicantJobAwards;
    }

    public CertOrAward(String email, String applicantJobAwards) {
        this.email = email;
        this.applicantJobAwards = applicantJobAwards;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApplicantJobAwards() {
        return applicantJobAwards;
    }

    public void setApplicantJobAwards(String description) {
        this.applicantJobAwards = description;
    }

    public CertOrAward toNonEmailForm(){
        return new CertOrAward(this.applicantJobAwards);
    }
}

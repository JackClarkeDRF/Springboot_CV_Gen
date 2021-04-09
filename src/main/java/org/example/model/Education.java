package org.example.model;

import javax.persistence.*;

/**
 * This Class holds the Education Object. It relates to the education table in the database schema 'ResumeDatabase'.
 * The Object holds the email of an individual. It also holds the Institution Name, Degree Type and Graduation date of
 * an individuals education history.
 *
 * The Primary Key of this schema is the email.
 */

@Entity
@Table(name = "education")
public class Education {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "institution_name")
    private String applicantEducationInst;

    @Column(name = "degree_type")
    private String applicantDegree;

    @Column(name = "grad_date")
    private String applicantGradDate;

    public Education(String email, String applicantEducationInst, String applicantDegree, String applicantGradDate){
        this.email = email;
        this.applicantEducationInst = applicantEducationInst;
        this.applicantDegree = applicantDegree;
        this.applicantGradDate = applicantGradDate;
    }

    public Education(String applicantEducationInst, String applicantDegree, String applicantGradDate){
        this.applicantEducationInst = applicantEducationInst;
        this.applicantDegree = applicantDegree;
        this.applicantGradDate = applicantGradDate;
    }

    public Education() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApplicantEducationInst() {
        return applicantEducationInst;
    }

    public void setApplicantEducationInst(String orgName) {

        this.applicantEducationInst = orgName;
    }

    public String getApplicantDegree() {

        return applicantDegree;
    }

    public void setApplicantDegree(String degreeType) {

        this.applicantDegree = degreeType;
    }

    public String getApplicantGradDate() {
        return applicantGradDate;
    }

    public void setApplicantGradDate(String grad_date) {
        this.applicantGradDate = grad_date;
    }

    public Education toNonEmailForm(){
        return new Education(this.applicantEducationInst,this.applicantDegree,this.applicantGradDate);
    }
}

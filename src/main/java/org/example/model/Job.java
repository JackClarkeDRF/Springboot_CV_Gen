package org.example.model;

import javax.persistence.*;

/**
 * This Class holds the Job Object. It relates to the jobs table in the database schema 'ResumeDatabase'.
 * The Object holds the email of an individual. It also holds the Organisation Name, Position, Start date, end date and
 * job description of an individuals work history.
 *
 * The Primary Key of this schema is the email.
 */

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "email")
    String email;

    @Column(name = "org_name")
    private String organisationName;

    @Column(name = "position")
    private String pastPosition;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "description")
    private String applicantJobDesc;

    public Job(String email, String organisationName, String pastPosition, String startDate, String endDate, String applicantJobDesc) {
        this.email = email;
        this.organisationName = organisationName;
        this.pastPosition = pastPosition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.applicantJobDesc = applicantJobDesc;
    }

    public Job(String organisationName, String pastPosition, String startDate, String endDate, String applicantJobDesc) {
        this.organisationName = organisationName;
        this.pastPosition = pastPosition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.applicantJobDesc = applicantJobDesc;
    }

    public Job() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String orgName) {
        this.organisationName = orgName;
    }

    public String getPastPosition() {
        return pastPosition;
    }

    public void setPastPosition(String position) {
        this.pastPosition = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String start_date) {
        this.startDate = start_date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String end_date) {
        this.endDate = end_date;
    }

    public String getApplicantJobDesc() {
        return applicantJobDesc;
    }

    public void setApplicantJobDesc(String description) {
        this.applicantJobDesc = description;
    }

    public Job toNonEmailForm(){
        return new Job(this.organisationName,this.pastPosition,this.startDate,this.endDate,this.applicantJobDesc);
    }
}

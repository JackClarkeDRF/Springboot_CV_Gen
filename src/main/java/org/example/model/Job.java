package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "email")
    String email;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "position")
    private String  position;

    @Column(name = "start_date")
    private String  start_date;

    @Column(name = "end_date")
    private String  end_date;

    @Column(name = "description")
    private String  description;

    public Job(String email, String orgName, String position, String start_date, String end_date, String description) {
        this.email = email;
        this.orgName = orgName;
        this.position = position;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }

    public Job(String orgName, String position, String start_date, String end_date, String description) {
        this.orgName = orgName;
        this.position = position;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }

    public Job() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job toNonEmailForm(){
        return new Job(this.orgName,this.position,this.start_date,this.end_date,this.description);
    }
}

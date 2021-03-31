package org.example.model;

import  javax.persistence.*;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Resume {

    private String name,email,phone_number,clearance_level;
    ArrayList<Skill> skills;
    ArrayList<Job> previous_jobs;
    ArrayList<Education> education;
    ArrayList<CertOrAward> certifications;

    /**
     * Handle null job & education & skills. What does that mean for the parsing of the json object back to the front end.
     *
     *
     */

    //TODO: Fix the arraylist methods to correctly handle an added value!
    public Resume(){

    }

    public Resume(String name, String email, String phone_number, String clearance_level, ArrayList<Skill> skills,
                  ArrayList<Job> previous_jobs, ArrayList<Education> education, ArrayList<CertOrAward> certifications)
    {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.clearance_level = clearance_level;
        this.skills = skills;
        this.previous_jobs = previous_jobs;
        this.education = education;
        this.certifications = certifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getClearance_level() {
        return clearance_level;
    }

    public void setClearance_level(String clearance_level) {
        this.clearance_level = clearance_level;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public ArrayList<Job> getPrevious_jobs() {
        return previous_jobs;
    }

    public void setPrevious_jobs(ArrayList<Job> previous_jobs) {
        this.previous_jobs = previous_jobs;
    }

    public ArrayList<Education> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<Education> education) {
        this.education = education;
    }

    public ArrayList<CertOrAward> getCertifications() {
        return certifications;
    }

    public void setCertifications(ArrayList<CertOrAward> certifications) {
        this.certifications = certifications;
    }

    //TODO: Implement a toJSON method
    public String toJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    //This Method will never be accessible
    public Resume fromJson(String str){
        Gson gson = new Gson();
        return gson.fromJson(str, Resume.class);
    }
}

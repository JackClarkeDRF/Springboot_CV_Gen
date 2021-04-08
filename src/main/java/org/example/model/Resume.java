package org.example.model;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;


/**
 * This Class holds the Resume Object. Which is a collated Object that contains the Objects BasicInfo, CertOrAward,
 * Education, Job and skill.
 *
 * This Class is used to collate the information together and then handle methods to convert itself into a Json Object
 * that can then be passed to a front end application.
 *
 */
//TODO: The Object should be refined so it holds a BasicInfo Object instead of these string variables.
//TODO: Can the Class handle empty types such as skills?
public class Resume {

    //private String name,email,phone_number,clearance_level;

    BasicInfo basicInfo;

    List<Skill> skills;
    List<Job> previous_jobs;
    List<Education> education;
    List<CertOrAward> certifications;

    public Resume(){

    }

    public Resume(BasicInfo basicInfo, List<Skill> skills,
                  List<Job> previous_jobs, List<Education> education, List<CertOrAward> certifications)
    {
        this.basicInfo = basicInfo;
        this.skills = skills;
        this.previous_jobs = previous_jobs;
        this.education = education;
        this.certifications = certifications;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone_number() {
//        return phone_number;
//    }
//
//    public void setPhone_number(String phone_number) {
//        this.phone_number = phone_number;
//    }
//
//    public String getClearance_level() {
//        return clearance_level;
//    }
//
//    public void setClearance_level(String clearance_level) {
//        this.clearance_level = clearance_level;
//    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Job> getPrevious_jobs() {
        return previous_jobs;
    }

    public void setPrevious_jobs(List<Job> previous_jobs) {
        this.previous_jobs = previous_jobs;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<CertOrAward> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<CertOrAward> certifications) {
        this.certifications = certifications;
    }

    /**
     * The toJSON() method converts a Resume object into a Json String.
     * @return Returns a Json String of a Resume object.
     */
    public String toJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}

package org.example.model;

import javax.persistence.*;

/**
 * This Class holds the Skill Object. It relates to the skills table in the database schema 'ResumeDatabase'.
 * The Object holds the email of an individual. It also holds a particular skill that relates to a person. This skill
 * is comprised of a name (i.e. Angular, java, etc.) and a ranking out of 5 for that skill.
 *
 * The Primary Key of this schema is the email.
 */
//TODO:This may need revision from it's current form.
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "skill_name")
    private String skill_name;

    @Column(name = "skill_level")
    private int skill_level;


    public Skill(String email, String skill_name, int skill_level){
        this.email = email;
        this.skill_name = skill_name;
        this.skill_level = skill_level;
    }


    public Skill(String skill_name, int skill_level){
        this.skill_name = skill_name;
        this.skill_level = skill_level;
    }

    public Skill(){

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public int getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(int skill_level) {
        this.skill_level = skill_level;
    }

    public Skill toNonEmailForm(){
        return new Skill(this.skill_name, this.skill_level);
    }

}

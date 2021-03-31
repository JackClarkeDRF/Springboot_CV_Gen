package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

package org.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "institution_name")
    private String orgName;

    @Column(name = "degree_type")
    private String degreeType;

    @Column(name = "grad_date")
    private String grad_date;

    public Education(String email, String orgName, String degreeType, String grad_date){
        this.email = email;
        this.orgName = orgName;
        this.degreeType = degreeType;
        this.grad_date = grad_date;
    }

    public Education(String orgName, String degreeType, String grad_date){
        this.orgName = orgName;
        this.degreeType = degreeType;
        this.grad_date = grad_date;
    }

    public Education() {

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

    public String getDegreeType() {

        return degreeType;
    }

    public void setDegreeType(String degreeType) {

        this.degreeType = degreeType;
    }

    public String getGrad_date() {
        return grad_date;
    }

    public void setGrad_date(String grad_date) {
        this.grad_date = grad_date;
    }

    public Education toNonEmailForm(){
        return new Education(this.orgName,this.degreeType,this.grad_date);
    }
}

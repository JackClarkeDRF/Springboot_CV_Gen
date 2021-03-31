package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cert_or_award")
public class CertOrAward {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String description;


    public CertOrAward(){

    }

    public CertOrAward(String description){
        this.description = description;
    }

    public CertOrAward(String email, String description) {
        this.email = email;
        this.description = description;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CertOrAward toNonEmailForm(){
        return new CertOrAward(this.description);
    }
}

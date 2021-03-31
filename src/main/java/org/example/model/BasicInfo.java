package org.example.model;


import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "basic_info")
public class BasicInfo {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private int id;

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "clearance")
    private String clearance;

//    @ElementCollection
//    @Column(name = "certs")
//    private List<String> certs;

    public BasicInfo(String name, String email, String phone, String clearance) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.clearance = clearance;
//        this.certs = certs;
    }

    public BasicInfo() {

    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClearance() {
        return clearance;
    }

    public void setClearance(String clearance) {
        this.clearance = clearance;
    }

//    public List<String> getCerts() {
//        return certs;
//    }
//
//    public void setCerts(List<String> certs) {
//        this.certs = certs;
//    }

}

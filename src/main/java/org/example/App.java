package org.example;


import com.google.gson.Gson;
import org.example.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages={
        "org.example.*", "org.example.controller","org.example.repository","org.example.service"})
@EnableJpaRepositories("org.example.repository")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
        jsonTester();
    }

    public static void jsonTester(){

        Gson json = new Gson();
//
        Skill testSkill = new Skill("Java", 6);
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(testSkill);
       // ArrayList skills = new ArrayList<>();

        Job testJob = new Job("DFR","Reception", "AUG 2020", "MAR 2021", "Boring!");
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(testJob);

        Education education = new Education("ANU", "BA", "2022");
        ArrayList<Education> educations = new ArrayList<>();
        educations.add(education);

        ArrayList<CertOrAward> certs = new ArrayList<>();
        CertOrAward cert1  = new CertOrAward("?Udemy cource");
        certs.add(cert1);



        Resume testResume = new Resume("Jack", "Jack@DRF.com","0455-658-293", "Baseline", skills, jobs, educations, certs );

        String jsonResume = json.toJson(testResume);

        System.out.println(jsonResume);


        Resume fromJsonToResume = json.fromJson(jsonResume, Resume.class);

        System.out.println(fromJsonToResume.getEmail());



    }
}

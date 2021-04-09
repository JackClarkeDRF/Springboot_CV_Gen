package org.example;

import com.google.gson.Gson;
import org.example.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages={
        "org.example.*", "org.example.controller","org.example.repository","org.example.service"})
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

        BasicInfo b_info = new BasicInfo("Jack", "Jack@drf.com","0455-658-293", "Baseline");

        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(new Skill ("Java", 6)));

        ArrayList<Job> jobs = new ArrayList<>(Arrays.asList(new Job("DFR","Reception", "A0", "MAR 2021", "Boring!")));

        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(new Education("ANU", "BA", "2022")));

        ArrayList<CertOrAward> certs = new ArrayList<>(Arrays.asList(new CertOrAward("Udemy course: Spark")));
        Resume testResume = new Resume(b_info, skills, jobs, educations, certs);

        String jsonResume = json.toJson(testResume);

        System.out.println(jsonResume);

        Resume fromJsonToResume = json.fromJson(jsonResume, Resume.class);

        System.out.println(fromJsonToResume.getBasicInfo().getEmail());



    }
}

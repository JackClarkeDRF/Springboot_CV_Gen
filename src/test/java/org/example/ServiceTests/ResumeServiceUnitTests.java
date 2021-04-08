package org.example.ServiceTests;

import org.example.model.*;
import org.example.service.ResumeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class ResumeServiceUnitTests {

    @Autowired
    ResumeService resumeService;

    @Test
    public void testGetByID(){

        BasicInfo b_info = new BasicInfo("Jack", "Jack@drf.com","0455-658-293", "Baseline");

        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(new Skill ("Java", 6)));

        ArrayList<Job> jobs = new ArrayList<>(Arrays.asList(new Job("DFR","Reception", "AUG 2020", "MAR 2021", "Boring!")));

        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(new Education("ANU", "BA", "2022")));

        ArrayList<CertOrAward> certs = new ArrayList<>(Arrays.asList(new CertOrAward("Udemy course: Spark")));

        Resume testResume = new Resume(b_info, skills, jobs, educations, certs);


    }

    @Test
    public void testCreateResume(){
        BasicInfo b_info = new BasicInfo("Jack", "Jack@drf.com","0455-658-293", "Baseline");

        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(new Skill ("Java", 6)));

        ArrayList<Job> jobs = new ArrayList<>(Arrays.asList(new Job("DFR","Reception", "AUG 2020", "MAR 2021", "Boring!")));

        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(new Education("ANU", "BA", "2022")));

        ArrayList<CertOrAward> certs = new ArrayList<>(Arrays.asList(new CertOrAward("Udemy course: Spark")));

        Resume testResume = new Resume(b_info, skills, jobs, educations, certs);

        resumeService.createResume(testResume);

        Resume newResume = resumeService.getByID(testResume.getBasicInfo().getEmail());

        assertNotNull(newResume);
        assertNotNull(newResume.getBasicInfo().getEmail());
        assertEquals(testResume, newResume);

    }
}

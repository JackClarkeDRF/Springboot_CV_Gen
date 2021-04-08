//package org.example;
//
//import com.google.gson.Gson;
//import org.example.controller.Controller;
//import org.example.model.*;
//import org.example.repository.BasicInfoRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = App.class)
//// @AutoConfigureMockMvc
//@TestPropertySource(
//        locations = "classpath:application-integrationtest.properties")
//@WebMvcTest(Controller.class)
//public class ResumeRestControllerIntegrationTest {
//
//    Gson json = new Gson();
//
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private BasicInfoRepository basicInfoRepository;
//
//    @Autowired
//    private Controller controller;
//
//
//    @Test
//    public void givenEmployees_whenGetEmployees_thenStatus200()
//            throws Exception {
//
//        BasicInfo b_info = new BasicInfo("Jack", "Jack@DRF.com","0455-658-293", "Baseline");
//
//        Skill testSkill = new Skill("Java", 6);
//        ArrayList<Skill> skills = new ArrayList<>();
//        skills.add(testSkill);
//
//        Job testJob = new Job("DFR","Reception", "AUG 2020", "MAR 2021", "Boring!");
//        ArrayList<Job> jobs = new ArrayList<>();
//        jobs.add(testJob);
//
//        Education education = new Education("ANU", "BA", "2022");
//        ArrayList<Education> educations = new ArrayList<>();
//        educations.add(education);
//
//        ArrayList<CertOrAward> certs = new ArrayList<>();
//        CertOrAward cert1  = new CertOrAward("Udemy course: Spark");
//        certs.add(cert1);
//
//        Resume testResume = new Resume(b_info, skills, jobs, educations, certs);
//        String jsonResume = json.toJson(testResume);
//
//        mvc.perform(post("/resume_model/post"),
//                    .contentType(MediaType.APPLICATION_JSON));
//
//        mvc.perform(controller.getResumeByID("employees")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].name", is("bob")));
//    }
//}

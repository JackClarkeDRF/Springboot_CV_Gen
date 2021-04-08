package org.example.controller;

import com.google.gson.Gson;
import org.example.model.*;
import org.example.repository.BasicInfoRepository;
import org.example.service.ResumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
//@EnableAutoConfiguration(exclude = {
//        JpaRepositoriesAutoConfiguration.class
//})
@WebMvcTest(Controller.class)
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    public ResumeService resumeService;

    @MockBean
    public BasicInfoRepository basicInfoRepository;


    Gson json = new Gson();

    @Test
    public void getAllResumes() {
    }

    @Test
    public void getResumeByID() throws Exception {

        BasicInfo b_info = new BasicInfo("Jack", "Jack@drf.com","0455-658-293", "Baseline");

        ArrayList<Skill> skills = new ArrayList<>(Arrays.asList(new Skill ("Java", 6)));

        ArrayList<Job> jobs = new ArrayList<>(Arrays.asList(new Job("DFR","Reception", "AUG 2020", "MAR 2021", "Boring!")));

        ArrayList<Education> educations = new ArrayList<>(Arrays.asList(new Education("ANU", "BA", "2022")));

        ArrayList<CertOrAward> certs = new ArrayList<>(Arrays.asList(new CertOrAward("Udemy course: Spark")));

        Resume testResume = new Resume(b_info, skills, jobs, educations, certs);

        given(resumeService.getByID("Jack@drf.com")).willReturn(testResume);
        String jsonResume = json.toJson(testResume);
//        RequestBuilder request = MockMvcRequestBuilders.post("/resume_model/post",jsonResume);
//        mvc.perform(request);


        RequestBuilder request1 = MockMvcRequestBuilders.get("/resume_model/Jack@drf.com");
        mvc.perform(get("/resume_model/Jack@drf.com").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //assertEquals(jsonResume, result.getResponse().getContentAsString());
    }

    @Test
    public void deleteResume() {
        // normal deletion
        // deleting something that doesnt exist
        //  after deleting once delete the same thing again and make sure it fails
    }

    @Test
    public void addResume() {
    }

    @Test
    public void updateResume() {
    }

}
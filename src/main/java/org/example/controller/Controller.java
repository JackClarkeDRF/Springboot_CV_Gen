package org.example.controller;

import com.google.gson.Gson;
import org.example.model.*;
import org.example.repository.BasicInfoRepository;
import org.example.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins= {"*"}, methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}, allowedHeaders="*")
@RequestMapping()
public class Controller {

    @Autowired
    ResumeService resumeService;
    @Autowired
    BasicInfoRepository basicInfoRepository;
    Gson json = new Gson();

    /**
     * The getAllResume() method is called by the front end application at address /resume_model/list. The method then
     * retrieves a List of all the resumes in the database.
     *
     * @return Returns a Json String that contain the list of all resumes in the database.
     */
    //TODO: Implement exception handling for the getAllResume() method
    @GetMapping(value = "/resume_model/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllResumes()  {

        List<Resume> resumesList = resumeService.getAllResumes();

        if (!resumesList.isEmpty()) {
            String entireJson = json.toJson(resumesList);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(entireJson);
        }else{
            System.out.println("The database is empty! Or something is not functioning correctly");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * The getResumeByID() method is the called by the front end application at string address /resume_model/{id}.
     *
     * @param id A String value that is the dynamic part of the link that specifies the resume we want to return.
     * @return Returns a json object that contains a complete resume.
     */
    //TODO: Possibly make changes to the unique identifier. Handle empty database exceptions. This shouldn't parse an array.
    @GetMapping(value = "/resume_model/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getResumeByID(@PathVariable("id") String id) {
//
//        BasicInfo bi_test = Optional.ofNullable(basicInfoRepository.findById(id).get()).get();
//        List<BasicInfo> test_list = new ArrayList<>();
//        test_list.add(bi_test);
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new String[]{json.toJson(bi_test)});

        Optional<Resume> resumeOptional = Optional.ofNullable(resumeService.getByID(id));
        if(resumeOptional.isPresent()){
            Resume selectedResume = resumeOptional.get();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(selectedResume.toJSON());

        } else {
            return new ResponseEntity<>( "No Resume with that ID found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method is called by the front end application at the string address /resume_model/delete/{id}. This method
     * will then call the resumeService to delete the specified resume.
     *
     * @param id A String value that is the dynamic part of the link that specifies the resume we want to return.
     */
    //TODO: Exception handling of invalid values.
    @DeleteMapping(value = "/resume_model/delete/{id}")
    public void deleteResume(@PathVariable("id") String id){

        resumeService.delete(id);
    }


    /**
     * The addResume() method is called by the front end application at address /resume_model/post. This method will then
     * call the resumeService to create the resume and place it in the database.
     *
     * @param resumeJson Is the Json string passed by the front end application that contains the information of a
     *                   persons resume.
     */
    //TODO: Figure out how the json string is actually passed and a;spo look into exception handling.
    //TODO: make this method return a Responce Entity that returns a HTTP status on the success of the add function.
    @PostMapping(value = "/resume_model/post")
    public void addResume(@RequestBody String resumeJson){
        Resume resume = json.fromJson(resumeJson, Resume.class);

        resumeService.createResume(resume);
        // Do we want to add a feature that says if the post was successful or not.

    }

    /**
     * The updateResume() method is called by the front end application at address /resume_model/update. This method
     * will then call the resumeService to update a resume based on the changes make in the json string.
     *
     * @param resumeJson Is the Json string passed by the front end application that contain the information of a
     *                   persons resume.
     */
    //TODO: Include exception handling.
    @PutMapping(value = "/resume_model/update")
    public void updateResume(@RequestBody String resumeJson){
        Resume resume = json.fromJson(resumeJson, Resume.class);
        resumeService.update(resume);
    }


}

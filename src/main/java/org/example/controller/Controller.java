package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.example.model.*;
import org.example.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= {"*"}, methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}, allowedHeaders="*")
@RestController
@RequestMapping()
public class Controller {

    @Autowired
    ResumeService resumeService;
    Gson json = new Gson();

    /**
     * Dont treat the resume as one table. it is actually 4 tables linked by an email address that we will the join together
     * and pass as a json object.
     * 4 natural join operations.
     * Forget about the join operations instead pull from each tab;e usingthe email as a unique identifier and then parse on
     * a josn string where the values of job are stroed as an array of type object.which if the job tabvle is empty for that email
     * then it just returns an empty array within the json string.
     * @return
     */


    //TODO: Implement the getAllResume() method
    @GetMapping(value = "/resume_model",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<String>> getAllResumes()  {
        int counter = 0;
        ArrayList resumesOBJ = new ArrayList<>(resumeService.getAllResumes());
        ArrayList<String> resumesAsJSON = new ArrayList<>();
        while(counter < resumesOBJ.size()){
            Resume currentResume = (Resume) resumesOBJ.get(counter);
            resumesAsJSON.add(currentResume.toJSON());
        }
        if (!resumesAsJSON.isEmpty()) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resumesAsJSON);
        }else{
            System.out.println("oh no!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //TODO: Implement the getResumeByID() method. Decide what the unique identifier is for each resume.
    @GetMapping(value = "/resume_model/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getResumeByID(@PathVariable("id") String id) {
        Optional<Resume> resumeOptional = Optional.ofNullable(resumeService.getByID(id));
        Resume selectedResume = resumeOptional.get();
        if(resumeOptional.isPresent()){
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(selectedResume.toJSON());

        } else {
            return new ResponseEntity<>( "No Resume with that ID found", HttpStatus.NOT_FOUND);
        }
    }

    //TODO: Implement the deleteResume() method
    @DeleteMapping(value = "/resume_model/delete/{id}")
    public void deleteResume(@PathVariable("id") String id){
        resumeService.delete(id);
    }


    //TODO: Implement the addResume() method. These Request Bodies may need to be a json string that is then interpreted.
    @PostMapping(value = "/resume_model/post")
    public void addResume(@RequestBody String resumeJson){
        Resume resume = json.fromJson(resumeJson, Resume.class);

        resumeService.createResume(resume);
        // Do we want to add a feature that says if the post was successful or not.

    }

    //TODO: Implement the updateResume() method
    @PutMapping(value = "/resume_model/update")
    public void updateResume(@RequestBody String resumeJson){
        Resume resume = json.fromJson(resumeJson, Resume.class);

        resumeService.update(resume);
    }


}

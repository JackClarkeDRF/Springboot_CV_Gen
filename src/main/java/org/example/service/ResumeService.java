package org.example.service;


import org.example.model.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@ComponentScan("org.example.*")
public class ResumeService {


    @Autowired
    private BasicInfoRepository basicInfoRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CertOrAwardRepository certOrAwardRepository;


    /**
     * The getAllResumes() Method will iterate through the entire database and return each entry in the ResumeDatabase
     * Schema as a resume.
     *
     * @return Returns a json String containing an array of every resume in the ResumeDatabase schema.
     */

    //TODO: Implement exception handling in the getAllResumes() Method.
    public List<Resume> getAllResumes(){

        long resumeCount = basicInfoRepository.countAll();
        List<BasicInfo> basicInfoList = basicInfoRepository.findAll();
        List<Resume> resumeList = new ArrayList<>();
        try {
            for(int i=0; i< resumeCount; i++){
                Resume current = getByID(basicInfoList.get(i).getEmail());
                resumeList.add(current);
            }

        }catch (NullPointerException e){
            System.out.println("Null Pointer the Database is empty " + e.getMessage());
        }
        return resumeList;
    }


    /**
     * The getByID() method will call the findByID() method in each of the repositories and then collate these returned
     * objects to produce a resume.If an invalid String is passed then the method will return an empty resume.
     *
     * Note: Each object is in its non-Email form except for the BasicInfo object which does not have a non-email form.
     *
     * @param id is the string value used to identify a unique resume. This is the email of an individual.
     * @return Returns a complete Resume of an individual.
     */
    public Resume getByID(String id){
        try {
            Optional<BasicInfo> basicInfoOptional = basicInfoRepository.findById(id);
            BasicInfo basicInfo = null;

            try {
                basicInfo = basicInfoOptional.get();
            }catch (NoSuchElementException e){
                return null;
            }

            String emailID = basicInfo.getEmail();


            List<Skill> skillList = skillRepository.findAllById(Collections.singleton(emailID)).stream()
                    .map(value -> value.toNonEmailForm())
                    .collect(Collectors.toList());

            List<Job> jobList = jobRepository.findAllById(Collections.singleton(emailID)).stream()
                    .map(value -> value.toNonEmailForm())
                    .collect(Collectors.toList());

            List<Education> educationList = educationRepository.findAllById(Collections.singleton(emailID))
                    .stream()
                    .map(value -> value.toNonEmailForm())
                    .collect(Collectors.toList());

            List<CertOrAward> certOrAwardList = certOrAwardRepository.findAllById(Collections.singleton(emailID)).stream()
                    .map(value -> value.toNonEmailForm())
                    .collect(Collectors.toList());

            return new Resume(basicInfo, skillList, jobList, educationList, certOrAwardList);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * The createResume() method will break down the resume object into the individual objects and then call the save()
     * methods in each of the repositories. To save the objects into the ResumeDatabase.
     *
     * @param resume This is the resume created in the controller class from the Json string passed in by the front end
     *               application.
     */
    public void createResume(Resume resume){

        BasicInfo basicInfo = resume.getBasicInfo();
        List<Job> prev_jobs = resume.getPrevious_jobs();
        List<Education> education = resume.getEducation();
        List<Skill> skills = resume.getSkills();
        List<CertOrAward> certs = resume.getCertifications();

        basicInfoRepository.save(basicInfo);

        for(int i=0;i<prev_jobs.size();i++)       {
            jobRepository.save(prev_jobs.get(i));
        }

        for(int i=0;i<prev_jobs.size();i++) {
            educationRepository.save(education.get(i));
        }

        for(int i=0;i<prev_jobs.size();i++) {
            skillRepository.save(skills.get(i));
        }
        for(int i=0;i<certs.size();i++) {
            certOrAwardRepository.save(certs.get(i));
        }
    }


    /**
     * The update() method works calls the createResume() method.
     *
     * @param resume This is the resume created in the controller class from the Json string passed in by the front end
     *               application.
     */
    public void update(Resume resume){
        createResume(resume);
    }

    /**
     * The delete() method calls the deleteById() method in each of the repositories which deletes the object in each
     * respective table in the ResumeDatabase schema.
     *
     * @param id This is the ID String of a resume which is the email of an individual.
     */
    public void delete(String id){
        basicInfoRepository.deleteById(id);
        jobRepository.deleteById(id);
        educationRepository.deleteById(id);
        skillRepository.deleteById(id);

    }
}

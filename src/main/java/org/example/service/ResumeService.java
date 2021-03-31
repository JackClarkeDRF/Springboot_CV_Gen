package org.example.service;


import org.example.model.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.*;

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


    public ArrayList<Resume> getAllResumes(){
        ArrayList<Resume> resumes = new ArrayList<>();
//        if(repository.count() != 0){
//            repository.findAll().forEach(resume -> resumes.add(resume));
//            return resumes;
//
//        }else{
//            return null;
//        }
        return null;
    }



    public Resume getByID(String id){
        System.out.println("VBefore the find by email call");
        BasicInfo basicInfo = basicInfoRepository.findById(id).get();
        System.out.println("After the find by email call");


        // BasicInfo basicInfo = basicInfoList.get(0);
        String name = basicInfo.getName();
        String emailID = basicInfo.getEmail();
        String phone_number = basicInfo.getPhone();
        String clearance = basicInfo.getClearance();
        // ArrayList<Boolean> skills = (ArrayList<Boolean>) basicInfo.getSkills();
        // List<String> certs =  basicInfo.getCerts();
        System.out.println(phone_number);
        //System.out.println(certs.get(0));


        Skill skill = skillRepository.findById(emailID).get();
        System.out.println(skill.getSkill_name());

        List<Skill> skillIterable = skillRepository.findAllByEmail((emailID));
        System.out.println(skillIterable.size());

        ArrayList<Skill> skillArrayList = new ArrayList<>();
        int skillCounter = 0;
        while(skillCounter < skillIterable.size()){
            skillArrayList.add(((List<Skill>) skillIterable).get(skillCounter).toNonEmailForm());
            skillCounter++;
        }

        // Need to do a find all operation on these
        List<Education> educationIterable = educationRepository.findAllById(Collections.singleton(emailID));

        ArrayList<Education> educationArrayList = new ArrayList<>();
        // Each value will now need to be trimmed dwn to its non email form then put into an array.

        //educationArrayList.addAll((Collection<? extends Education>) educationIterable);
        int eduCounter = 0;
        while(eduCounter < educationIterable.size()){
            educationArrayList.add(((List<Education>) educationIterable).get(eduCounter).toNonEmailForm());
            eduCounter++;
        }


        // Education Education = educationRepository.findById(emailID).get();
        List<Job> jobIterable = jobRepository.findAllById(Collections.singleton(emailID));
        ArrayList<Job> jobArrayList = new ArrayList<>();
        int jobCounter = 0;
        while (jobCounter < jobIterable.size()){
            jobArrayList.add(((List<Job>) jobIterable).get(jobCounter).toNonEmailForm());
            jobCounter++;
        }

        List<CertOrAward> certOrAwardIterable = certOrAwardRepository.findAllById(Collections.singleton(emailID));
        ArrayList<CertOrAward> certOrAwardArrayList = new ArrayList<>();
        int certCounter = 0;
        while (certCounter < certOrAwardIterable.size()){
            certOrAwardArrayList.add(((certOrAwardIterable).get(certCounter).toNonEmailForm()));
        }


        Resume currentResume = new Resume(name,emailID,phone_number,clearance,skillArrayList,jobArrayList,educationArrayList,certOrAwardArrayList);

        return currentResume;
    }

    public void createResume(Resume resume){


        String name = resume.getName();
        String email = resume.getEmail();
        String phone_number = resume.getPhone_number();
        String clearance = resume.getClearance_level();
        List<CertOrAward> certs = resume.getCertifications();

        BasicInfo basicInfo = new BasicInfo(name,email,phone_number,clearance);
        List<Job> prev_jobs = resume.getPrevious_jobs();
        List<Education> education = resume.getEducation();
        List<Skill> skills = resume.getSkills();

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
    }



    public void update(Resume resume){

//        String name = resume.getName();
//        String email = resume.getEmail();
//        String phone_number = resume.getPhone_number();
//        String clearance = resume.getClearance_level();
//        List<String> certs = resume.getCertifications();
//
//        BasicInfo basicInfo = new BasicInfo(name,email,phone_number,clearance,certs);
//        List<Job> prev_jobs = resume.getPrevious_jobs();
//        List<Education> education = resume.getEducation();
//        List<Skill> skills = resume.getSkills();
//
//        basicInfoRepository.save(basicInfo);
//
//        for(int i=0;i<prev_jobs.size();i++)       {
//            jobRepository.save(prev_jobs.get(i));
//        }
//
//        for(int i=0;i<prev_jobs.size();i++) {
//            educationRepository.save(education.get(i));
//        }
//
//        for(int i=0;i<prev_jobs.size();i++) {
//            skillRepository.save(skills.get(i));
//        }
    }

    public void delete(String id){
        basicInfoRepository.deleteById(id);
        jobRepository.deleteById(id);
        educationRepository.deleteById(id);
        skillRepository.deleteById(id);

    }
}

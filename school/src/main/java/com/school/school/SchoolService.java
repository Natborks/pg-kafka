package com.school.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;


    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createSchool(School student){
        try{
            return new ResponseEntity<School>(schoolRepository.save(student), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchSchool(){
        List<School> students = schoolRepository.findAll();
        if(students.size() > 0){
            return new ResponseEntity<List<School>>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
    }

}

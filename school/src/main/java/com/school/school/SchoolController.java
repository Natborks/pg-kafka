package com.school.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/")
    public ResponseEntity<?> fetchSchools(){
        return schoolService.fetchSchool();
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody School school){
        return schoolService.createSchool(school);
    }
}

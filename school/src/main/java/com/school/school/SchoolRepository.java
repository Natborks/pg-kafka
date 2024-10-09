package com.school.school;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface SchoolRepository extends MongoRepository<School, String>{
}

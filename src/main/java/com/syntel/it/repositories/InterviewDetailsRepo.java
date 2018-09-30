package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface InterviewDetailsRepo extends Repository<InterviewDetails, Integer> {
    String getInterviewDetailsById = "SELECT * FROM interview_details WHERE ID = ?1";

    @Query(nativeQuery = true, value = getInterviewDetailsById)
    List<InterviewDetails> getInterviewDetailsById(String intId);
}

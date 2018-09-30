package com.syntel.it.repositories;

import com.syntel.it.entities.ApplicantDetails;
import com.syntel.it.entities.InterviewStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface ApplicantDetailsRepo extends Repository<ApplicantDetails, Integer> {
    String getApplicantDetailsById = "SELECT * FROM applicant_details WHERE ID = ?1";

    @Query(nativeQuery = true, value = getApplicantDetailsById)
    List<ApplicantDetails> getApplicantDetailsById(String applicationId);
}

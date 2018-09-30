package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewStatus;
import com.syntel.it.entities.JobDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface JobDetailsRepo extends Repository<JobDetails, Integer> {
    String getJobDetails = "SELECT * FROM job_details WHERE ID = ?1";

    @Query(nativeQuery = true, value = getJobDetails)
    List<JobDetails> getJobDetails(String jobId);
}

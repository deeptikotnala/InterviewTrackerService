package com.syntel.it.repositories;
import com.syntel.it.entities.JobDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface JobDetailsRepo extends Repository<JobDetails, Integer> {

    String getJobDetailsById = "SELECT * FROM JOB_DETAILS WHERE ID = ?1";
    String getJobDetails = "SELECT * FROM JOB_DETAILS";

    @Query(nativeQuery = true, value = getJobDetailsById)
    List<JobDetails> getJobDetailsById(String jobId);

    @Query(nativeQuery = true, value = getJobDetails)
    List<JobDetails> getJobDetails();
}

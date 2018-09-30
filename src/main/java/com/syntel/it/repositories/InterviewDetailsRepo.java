package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface InterviewDetailsRepo extends Repository<InterviewDetails, Integer> {
    String getInterviewDetailsById = "SELECT * FROM interview_details WHERE ID = ?1";
    String getInterviewDetails = "select b.id,a.first_Name,a.last_name ,a.skills ,b.evaluator_name,b.evaluator_comments,b.int_datetime ,b.timezone,c.job_type ,d.INT_RSLT \n" +
            "from applicant_details a , interview_details b ,job_details c , interview_rslt d\n" +
            "where a.id=b.applicant_id and c.id=b.job_id and b.int_result_id=d.id";

    @Query(nativeQuery = true, value = getInterviewDetailsById)
    List<InterviewDetails> getInterviewDetailsById(String intId);

    @Query(nativeQuery = true, value = getInterviewDetails)
    List<InterviewDetails> getInterviewDetails();
}

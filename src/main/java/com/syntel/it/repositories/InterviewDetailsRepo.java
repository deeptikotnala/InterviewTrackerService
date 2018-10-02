package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface InterviewDetailsRepo extends Repository<InterviewDetails, Integer> {
    String getInterviewDetailsById = "SELECT * FROM interview_details WHERE ID = ?1";
    String getInterviewDetails = "select b.id,a.first_Name,a.last_name ,a.skills ,b.evaluator_name,b.evaluator_comments,b.int_datetime ,b.timezone,c.job_type ,d.INT_RSLT \n" +
            "from applicant_details a , interview_details b ,job_details c , interview_rslt d\n" +
            "where a.id=b.applicant_id and c.id=b.job_id and b.int_result_id=d.id";

    String updateInterviewDetailsById ="UPDATE interview_details SET evaluator_comments = ?1, int_result_id = ?2 WHERE id=?3";

    @Query(nativeQuery = true, value = getInterviewDetailsById)
    List<InterviewDetails> getInterviewDetailsById(String intId);

    @Query(nativeQuery = true, value = getInterviewDetails)
    List<InterviewDetails> getInterviewDetails();


    @Modifying
    @Transactional
    @Query(updateInterviewDetailsById)
    void updateInterviewDetailsById(String comment, int result, int id);

    <S extends InterviewDetails> S save(S entity);
}

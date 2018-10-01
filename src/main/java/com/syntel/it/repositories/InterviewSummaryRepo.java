package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewStatus;
import com.syntel.it.entities.InterviewSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface InterviewSummaryRepo extends Repository<InterviewSummary, Integer> {
    String getInterviewSummary = "select b.id,a.first_Name,a.last_name ,a.skills ,b.evaluator_name,b.evaluator_comments," +
            "b.int_datetime ,b.timezone,c.job_type ,d.INT_RSLT ,b.evaluator_email_id,e.type\n" +
            "            from applicant_details a , interview_details b ,job_details c , interview_rslt d,int_type e\n" +
            "where a.id=b.applicant_id and c.id=b.job_id and b.int_result_id=d.id and b.int_type_id =e.id and b.id=?1";

    @Query(nativeQuery = true, value = getInterviewSummary)
    List<InterviewSummary> getInterviewSumary(String intId);
}

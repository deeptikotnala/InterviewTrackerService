package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewDetailsResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface InterviewDetailsResponseRepo extends Repository<InterviewDetailsResponse, Integer> {
    String getInterviewDetails = 
            "SELECT " +
                    "    B.ID, " +
                    "    A.FIRST_NAME, " +
                    "    A.LAST_NAME, " +
                    "    A.SKILLS, " +
                    "    B.EVALUATOR_NAME, " +
                    "    B.EVALUATOR_COMMENTS, " +
                    "    B.INT_DATETIME, " +
                    "    B.TIMEZONE, " +
                    "    C.JOB_TYPE, " +
                    "    D.INT_RSLT " +
                    "FROM " +
                    "    APPLICANT_DETAILS A, " +
                    "    INTERVIEW_DETAILS B, " +
                    "    JOB_DETAILS C, " +
                    "    INTERVIEW_RSLT D " +
                    "WHERE " +
                    "    A.ID = B.APPLICANT_ID " +
                    "        AND C.ID = B.JOB_ID " +
                    "        AND B.INT_RESULT_ID = D.ID " +
                    "ORDER BY B.CREATED_DATE DESC ";

    @Query(nativeQuery = true, value = getInterviewDetails)
    List<InterviewDetailsResponse> getInterviewDetails();
}

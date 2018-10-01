package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewResults;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface InterviewResultsRepo extends Repository<InterviewResults, Integer> {
    String getApplicantInterviewResultsByJobAndId =
            "SELECT A.ID, " +
                    "       B.TYPE, " +
                    "       A.INT_DATETIME, " +
                    "       C.INT_RSLT, " +
                    "       A.EVALUATOR_NAME, " +
                    "       A.EVALUATOR_COMMENTS," +
                    "       A.EVALUATOR_EMAIL_ID," +
                    "       A.TIMEZONE " +
                    "FROM   INTERVIEW_DETAILS A " +
                    "       JOIN INT_TYPE B " +
                    "         ON A.INT_TYPE_ID = B.ID " +
                    "       JOIN INTERVIEW_RSLT C " +
                    "         ON A.INT_RESULT_ID = C.ID " +
                    "WHERE  A.APPLICANT_ID = ?1 " +
                    "       AND A.JOB_ID = ?2 " +
                    "ORDER  BY CREATED_DATE DESC ";

    @Query(nativeQuery = true, value = getApplicantInterviewResultsByJobAndId)
    List<InterviewResults> getApplicantInterviewResultsByJobAndId(int applicantId, int jobId);
}

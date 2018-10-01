package com.syntel.it.repositories;

import com.syntel.it.entities.Applicant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


import java.util.List;


public interface ApplicantRepo extends Repository<Applicant, Integer> {
    String getApplicantDetailsById =
            "SELECT A.ID, " +
                    "       A.FIRST_NAME, " +
                    "       A.LAST_NAME, " +
                    "       A.EMAIL_ID, " +
                    "       A.PHONE_NO, " +
                    "       A.SKILLS, " +
                    "       A.SPONSORSHIP_REQ, " +
                    "       A.OVERALL_STATUS, " +
                    "       A.IS_SELECTED, " +
                    "       A.ACTIVE_FLG, " +
                    "       B.JOB_TYPE, " +
                    "       B.ID AS JOB_ID, "+
                    "       B.BEGIN_DATE, " +
                    "       B.ACCOUNT_NAME, " +
                    "       B.HIRING_MANAGER, " +
                    "       B.STATUS, " +
                    "       B.LOCATION, " +
                    "       B.CAREER_LEVEL " +
                    "FROM   APPLICANT_DETAILS A " +
                    "       JOIN JOB_DETAILS B " +
                    "         ON A.JOB_DETAIL_ID = B.ID " +
                    "WHERE  A.ACTIVE_FLG = 1 " +
                    "       AND B.ACTIVE_FLG = 1 " +
                    "       AND A.ID = ?1 ";


    @Query(nativeQuery = true, value = getApplicantDetailsById)
    List<Applicant> getApplicantDetailsById(String applicationId);
}

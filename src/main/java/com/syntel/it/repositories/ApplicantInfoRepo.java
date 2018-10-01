package com.syntel.it.repositories;

import com.syntel.it.entities.ApplicantInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
public interface ApplicantInfoRepo extends Repository<ApplicantInfo, Integer> {
    String getApplicantLastTenRecords =
            "SELECT " +
                    "A.ID," +
                    "A.FIRST_NAME,  " +
                    "A.LAST_NAME,  " +
                    "A.EMAIL_ID, " +
                    "A.PHONE_NO, " +
                    "B.JOB_TYPE AS POSITION " +
                    "FROM APPLICANT_DETAILS A " +
                    "JOIN JOB_DETAILS B ON A.JOB_DETAIL_ID = B.ID " +
                    "ORDER BY CREATED_DATE DESC " +
                    "LIMIT 10 ";

    String getAllApplications =
            "SELECT " +
                    "A.ID," +
                    "A.FIRST_NAME,  " +
                    "A.LAST_NAME,  " +
                    "A.EMAIL_ID, " +
                    "A.PHONE_NO, " +
                    "B.JOB_TYPE AS POSITION " +
                    "FROM APPLICANT_DETAILS A " +
                    "JOIN JOB_DETAILS B ON A.JOB_DETAIL_ID = B.ID " +
                    "ORDER BY CREATED_DATE DESC" ;

    @Query(nativeQuery = true, value = getApplicantLastTenRecords)
    List<ApplicantInfo> getApplicantLastTenRecords();

    @Query(nativeQuery = true, value = getAllApplications)
    List<ApplicantInfo> getAllApplications();
    
}

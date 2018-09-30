package com.syntel.it.repositories;

import com.syntel.it.entities.InterviewStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface InterviewStatusRepo extends Repository<InterviewStatus, Integer> {
    String getInterviewStatuses = "SELECT ID, INT_RSLT FROM INTERVIEW_RSLT";

    @Query(nativeQuery = true, value = getInterviewStatuses)
    List<InterviewStatus> getInterviewStatuses();
}

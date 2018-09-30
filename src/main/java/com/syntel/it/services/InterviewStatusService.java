package com.syntel.it.services;

import com.syntel.it.entities.InterviewStatus;
import com.syntel.it.repositories.InterviewStatusRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InterviewStatusService {

    @Autowired
    private InterviewStatusRepo interviewStatusRepo;

    public List<InterviewStatus> getInterviewStatuses() {

        return interviewStatusRepo.getInterviewStatuses();

    }
}

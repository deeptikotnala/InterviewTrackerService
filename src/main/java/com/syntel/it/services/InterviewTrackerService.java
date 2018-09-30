package com.syntel.it.services;

import com.syntel.it.entities.*;
import com.syntel.it.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InterviewTrackerService {

    @Autowired
    private InterviewStatusRepo interviewStatusRepo;

    @Autowired
    private ApplicantDetailsRepo applicantDetailsRepo;

    @Autowired
    private InterviewDetailsResponseRepo interviewDetailsResponseRepo;

    @Autowired
    private InterviewDetailsRepo interviewDetailsRepo;

    @Autowired
    private JobDetailsRepo jobDetailsRepo;


    public List<InterviewStatus> getInterviewStatuses() {
        return interviewStatusRepo.getInterviewStatuses();
    }

    public List<ApplicantDetails> getApplicantDetailsById(String applicantId) {
        return applicantDetailsRepo.getApplicantDetailsById(applicantId);
    }

    public List<InterviewDetails> getInterviewDetailsById(String intId) {
        return interviewDetailsRepo.getInterviewDetailsById(intId);
    }
    public List<InterviewDetailsResponse> getInterviewDetails() {
        return interviewDetailsResponseRepo.getInterviewDetails();
    }

    public List<JobDetails> getJobDetailsById(String jobId) {
        return jobDetailsRepo.getJobDetailsById(jobId);
    }

    public List<JobDetails> getJobDetails() {
        return jobDetailsRepo.getJobDetails();
    }
}

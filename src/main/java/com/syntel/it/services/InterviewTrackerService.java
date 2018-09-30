package com.syntel.it.services;

import com.syntel.it.entities.ApplicantDetails;
import com.syntel.it.entities.InterviewStatus;
import com.syntel.it.entities.InterviewDetails;
import com.syntel.it.entities.JobDetails;
import com.syntel.it.repositories.ApplicantDetailsRepo;
import com.syntel.it.repositories.InterviewDetailsRepo;
import com.syntel.it.repositories.InterviewStatusRepo;
import com.syntel.it.repositories.JobDetailsRepo;
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
    private InterviewDetailsRepo interviewDetailsRepo;

    @Autowired
    private JobDetailsRepo jobDetailsRepo;


    public List<InterviewStatus> getInterviewStatuses() {
        return interviewStatusRepo.getInterviewStatuses();
    }

    public List<ApplicantDetails> getApplicantDetails(String applicantId) {
        return applicantDetailsRepo.getApplicantDetails(applicantId);
    }

    public List<InterviewDetails> getInterviewDetails(String intId) {

        return interviewDetailsRepo.getInterviewDetails(intId);
    }

    public List<JobDetails> getJobDetails(String jobId) {
        return jobDetailsRepo.getJobDetails(jobId);
    }
}

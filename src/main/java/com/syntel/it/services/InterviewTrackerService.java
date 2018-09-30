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

    public List<ApplicantDetails> getApplicantDetailsById(String applicantId) {
        return applicantDetailsRepo.getApplicantDetailsById(applicantId);
    }

    public List<InterviewDetails> getInterviewDetailsById(String intId) {
        return interviewDetailsRepo.getInterviewDetailsById(intId);
    }
    public List<InterviewDetails> getInterviewDetails() {
        return interviewDetailsRepo.getInterviewDetails();
    }

    public List<JobDetails> getJobDetailsById(String jobId) {
        return jobDetailsRepo.getJobDetailsById(jobId);
    }

    public List<JobDetails> getJobDetails() {
        return jobDetailsRepo.getJobDetails();
    }

    public void addNewApplication(ApplicantDetails applicantDetails) {
        applicantDetails.setActiveFlag(1);
        applicantDetailsRepo.save(applicantDetails);
    }
}

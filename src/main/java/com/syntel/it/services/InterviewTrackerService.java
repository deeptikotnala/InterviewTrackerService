package com.syntel.it.services;

import com.syntel.it.entities.*;
import com.syntel.it.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    @Autowired
    private ApplicantInfoRepo applicantInfoRepo;

    @Autowired
    private ApplicantRepo applicantRepo;

    @Autowired
    private InterviewResultsRepo interviewResultsRepo;

    @Autowired
    private InterviewSummaryRepo interviewSummaryRepo;



    public List<InterviewStatus> getInterviewStatuses() {
        return interviewStatusRepo.getInterviewStatuses();
    }

    public List<Applicant> getApplicantDetailsById(String applicantId) {
        return applicantRepo.getApplicantDetailsById(applicantId);
    }

    public List<InterviewDetails> getInterviewDetailsById(String intId) {
        return interviewDetailsRepo.getInterviewDetailsById(intId);
    }
    public List<InterviewDetailsResponse> getInterviewDetails() {
        return interviewDetailsResponseRepo.getInterviewDetails();
    }

    public List<InterviewSummary> getInterviewSummary(String intId) {
        return interviewSummaryRepo.getInterviewSumary(intId);
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

    public void addNewInterview(InterviewDetails interviewDetails) {
        interviewDetailsRepo.save(interviewDetails);
    }

    public void updateInterview(InterviewDetails interviewDetails) {
        interviewDetailsRepo.updateInterviewDetailsById(interviewDetails.getEvaluatorComment(),interviewDetails.getIntResultId(),interviewDetails.getId());
    }

    public List<ApplicantInfo> getLastTenApplications(){
        return applicantInfoRepo.getApplicantLastTenRecords();
    }

    public List<ApplicantInfo> getAllApplications(){
        return applicantInfoRepo.getAllApplications();
    }

    public List<InterviewResults> getApplicantInterviewResultsByJobAndId(int applicantId, int jobId){
        return interviewResultsRepo.getApplicantInterviewResultsByJobAndId(applicantId, jobId);
    }
}

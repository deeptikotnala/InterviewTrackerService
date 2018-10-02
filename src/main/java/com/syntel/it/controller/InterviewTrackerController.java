package com.syntel.it.controller;

import com.syntel.it.entities.*;
import com.syntel.it.services.InterviewTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class InterviewTrackerController {

    @Autowired
    private InterviewTrackerService interviewTrackerService;

    @RequestMapping(value = "/getIntStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewStatuses() {
        List<InterviewStatus> interviewStatusList = interviewTrackerService.getInterviewStatuses();
        return ResponseEntity.ok(interviewStatusList);
    }
    @RequestMapping(value = "/getApplicantById/{applicantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getApplicantDetailsById(@PathVariable("applicantId") String applicantId) {
        List<Applicant> applicants = interviewTrackerService.getApplicantDetailsById(applicantId);
        return ResponseEntity.ok(applicants);
    }

    @RequestMapping(value = "/getInterviewDetails/{intId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewDetailsByIntId(@PathVariable("intId") String intId) {
        List<InterviewDetails> interviewDetails = interviewTrackerService.getInterviewDetailsById(intId);
        return ResponseEntity.ok(interviewDetails);
    }

    @RequestMapping(value = "/getInterviewDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewDetails() {
        List<InterviewDetailsResponse> interviewDetails = interviewTrackerService.getInterviewDetails();
        return ResponseEntity.ok(interviewDetails);
    }

    @RequestMapping(value = "/getInterviewSummary/{intId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewSummary(@PathVariable("intId") String intId) {
        List<InterviewSummary> interviewDetails = interviewTrackerService.getInterviewSummary(intId);
        return ResponseEntity.ok(interviewDetails);
    }

    @RequestMapping(value = "/getJobDetails/{jobId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getJobDetailsById(@PathVariable("jobId") String jobId) {
        List<JobDetails> jobDetails = interviewTrackerService.getJobDetailsById(jobId);
        return ResponseEntity.ok(jobDetails);
    }

    @RequestMapping(value = "/getJobDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getJobDetails() {
        List<JobDetails> jobDetails = interviewTrackerService.getJobDetails();
        return ResponseEntity.ok(jobDetails);
    }

    @RequestMapping(value = "/addNewApplication", method = RequestMethod.POST)
    public ResponseEntity addNewApplication(@RequestBody ApplicantDetails applicantDetails) {
        interviewTrackerService.addNewApplication(applicantDetails);
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

    @RequestMapping(value = "/addNewInterview", method = RequestMethod.POST)
    public ResponseEntity addNewInterview(@RequestBody InterviewDetails interviewDetails) {
        interviewTrackerService.addNewInterview(interviewDetails);
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

    @RequestMapping(value = "/updateInterview", method = RequestMethod.POST)
    public ResponseEntity updateInterview(@RequestBody InterviewDetails interviewDetails) {
        interviewTrackerService.updateInterview(interviewDetails);
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

    @RequestMapping(value = "/getLastApplications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getLastTenApplications(){
        List<ApplicantInfo> applicantInfos = interviewTrackerService.getLastTenApplications();
        return ResponseEntity.ok(applicantInfos);
    }

    @RequestMapping(value = "/getAllApplications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAllApplications(){
        List<ApplicantInfo> applicantInfos = interviewTrackerService.getAllApplications();
        return ResponseEntity.ok(applicantInfos);
    }

    @RequestMapping(value = "/getOverallFeedback/{appId}/{jobId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getApplicantInterviewResultsByJobAndId(@PathVariable("appId") int appId, @PathVariable("jobId") int jobId){
        List<InterviewResults> applicantInfos = interviewTrackerService.getApplicantInterviewResultsByJobAndId(appId,jobId);
        return ResponseEntity.ok(applicantInfos);
    }
}

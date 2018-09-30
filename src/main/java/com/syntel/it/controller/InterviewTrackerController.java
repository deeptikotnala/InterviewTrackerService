package com.syntel.it.controller;

import com.syntel.it.entities.ApplicantDetails;
import com.syntel.it.entities.InterviewDetails;
import com.syntel.it.entities.InterviewStatus;
import com.syntel.it.entities.JobDetails;
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
    @RequestMapping(value = "/getApplicantDetails/{applicantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getApplicantDetailsById(@PathVariable("applicantId") String applicantId) {
        List<ApplicantDetails> applicants = interviewTrackerService.getApplicantDetailsById(applicantId);
        return ResponseEntity.ok(applicants);
    }

    @RequestMapping(value = "/getInterviewDetails/{intId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewDetailsByIntId(@PathVariable("intId") String intId) {
        List<InterviewDetails> interviewDetails = interviewTrackerService.getInterviewDetailsById(intId);
        return ResponseEntity.ok(interviewDetails);
    }

    @RequestMapping(value = "/getInterviewDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewDetails() {
        List<InterviewDetails> interviewDetails = interviewTrackerService.getInterviewDetails();
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
}

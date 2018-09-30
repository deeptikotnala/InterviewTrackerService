package com.syntel.it.controller;

import com.syntel.it.entities.ApplicantDetails;
import com.syntel.it.entities.InterviewDetails;
import com.syntel.it.entities.InterviewStatus;
import com.syntel.it.entities.JobDetails;
import com.syntel.it.services.InterviewTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class ApplicationController {

    @Autowired
    private InterviewTrackerService interviewTrackerService;

    @RequestMapping(value = "/getIntStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewStatuses() {
        List<InterviewStatus> interviewStatusList = interviewTrackerService.getInterviewStatuses();
        return ResponseEntity.ok(interviewStatusList);
    }
    @RequestMapping(value = "/getApplicantDetails/{applicantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getApplicantDetails(@PathVariable("applicantId") String applicantId) {
        List<ApplicantDetails> interviewStatusList = interviewTrackerService.getApplicantDetails(applicantId);
        return ResponseEntity.ok(interviewStatusList);
    }

    @RequestMapping(value = "/getInterviewDetails/{intId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewDetails(@PathVariable("intId") String intId) {
        List<InterviewDetails> interviewStatusList = interviewTrackerService.getInterviewDetails(intId);
        return ResponseEntity.ok(interviewStatusList);
    }

    @RequestMapping(value = "/getJobDetails/{jobId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getJobDetails(@PathVariable("jobId") String jobId) {
        List<JobDetails> interviewStatusList = interviewTrackerService.getJobDetails(jobId);
        return ResponseEntity.ok(interviewStatusList);
    }



}

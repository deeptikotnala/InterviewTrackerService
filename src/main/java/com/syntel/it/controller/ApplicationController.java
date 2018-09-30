package com.syntel.it.controller;

import com.syntel.it.entities.InterviewStatus;
import com.syntel.it.services.InterviewStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class ApplicationController {

    @Autowired
    private InterviewStatusService interviewStatusService;

    @RequestMapping(value = "/getIntStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getInterviewStatuses() {
        List<InterviewStatus> interviewStatusList = interviewStatusService.getInterviewStatuses();
        return ResponseEntity.ok(interviewStatusList);
    }
}

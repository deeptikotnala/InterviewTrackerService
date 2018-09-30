package com.syntel.it.services;

import com.syntel.it.entities.JobDetails;
import com.syntel.it.repositories.JobDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobDetailsService {

    @Autowired
    private JobDetailsRepo jobDetailsRepo;

    public List<JobDetails> getJobDetails() {
        return jobDetailsRepo.getJobDetails();
    }
}

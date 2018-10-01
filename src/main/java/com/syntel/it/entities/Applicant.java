package com.syntel.it.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Applicant {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "JOB_ID")
    private Integer jobId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name="PHONE_NO")
    private String phoneNo;

    @Column(name = "SKILLS")
    private String skills;

    @Column(name = "SPONSORSHIP_REQ")
    private int sponsorshipReq;

    @Column(name = "ACTIVE_FLG")
    private int activeFlag;

    @Column(name = "IS_SELECTED")
    private int isSelected;

    @Column(name = "OVERALL_STATUS")
    private String overallStatus;

    @Column(name = "JOB_TYPE")
    private String jobType;

    @Column(name = "BEGIN_DATE")
    private String beginDate;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "HIRING_MANAGER")
    private String hiringManager;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "CAREER_LEVEL")
    private String careerLevel;

}


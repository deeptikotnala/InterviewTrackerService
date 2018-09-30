package com.syntel.it.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="APPLICANT_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDetails {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "SKILLS")
    private String skills;

    @Column(name = "JOB_DETAIL_ID")
    private int jobDetailId;

    @Column(name = "SPONSORSHIP_REQ")
    private int sponsorshipReq;

    @Column(name = "ACTIVE_FLG")
    private int activeFlag;

    @Column(name = "IS_SELECTED")
    private int isSelected;

    @Column(name = "OVERALL_STATUS")
    private String overallStatus;


}

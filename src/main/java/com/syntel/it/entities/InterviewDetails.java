package com.syntel.it.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="interview_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterviewDetails {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "JOB_ID")
    private Integer jobId;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "APPLICANT_ID")
    private Integer applicantId;

    @Column(name = "INT_TYPE_ID")
    private Integer intTypeId;

    @Column(name = "INT_RESULT_ID")
    private Integer intResultId;

    @Column(name = "INT_DATETIME")
    private Date intDateTime;

    @Column(name = "TIMEZONE")
    private String intTimeZone;

    @Column(name = "EVALUATOR_NAME")
    private String evaluatorName;

    @Column(name = "EVALUATOR_COMMENTS")
    private String evaluatorComment;


}

package com.syntel.it.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterviewDetails {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "JOB_ID")
    private Integer jobId;

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

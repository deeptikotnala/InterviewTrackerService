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
public class InterviewResults {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "INT_DATETIME")
    private String intDate;

    @Column(name = "INT_RSLT")
    private String interviewResult;

    @Column(name="EVALUATOR_NAME")
    private String evaluatorName;

    @Column(name = "EVALUATOR_COMMENTS")
    private String evaluatorComments;

    @Column(name = "TIMEZONE")
    private String timezone;

    @Column(name = "EVALUATOR_EMAIL_ID")
    private String evaluatorEmailId;

}


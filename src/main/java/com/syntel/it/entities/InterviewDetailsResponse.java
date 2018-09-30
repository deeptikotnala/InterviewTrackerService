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
public class InterviewDetailsResponse {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SKILLS")
    private String skills;

    @Column(name = "INT_RSLT")
    private String status;

    @Column(name = "INT_DATETIME")
    private Date intDateTime;

    @Column(name = "TIMEZONE")
    private String intTimeZone;

    @Column(name = "EVALUATOR_NAME")
    private String evaluatorName;

    @Column(name = "EVALUATOR_COMMENTS")
    private String evaluatorComment;
}


package com.syntel.it.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDetails {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "JOB_TYPE")
    private String jobType;

    @Column(name = "CAREER_LEVEL")
    private String careerLevel;

    @Column(name = "BEGIN_DATE")
    private String beginDate;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "HIRING_MANAGER")
    private String hiringManager;

    @Column(name = "ACTIVE_FLG")
    private String activeFlag;

    @Column(name = "STATUS")
    private String status;

}

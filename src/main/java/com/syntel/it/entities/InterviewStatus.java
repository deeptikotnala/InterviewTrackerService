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
public class InterviewStatus {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "INT_RSLT")
    private String interviewResult;
}

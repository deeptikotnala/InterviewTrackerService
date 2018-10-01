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
public class ApplicantInfo {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "PHONE_NO")
    private String phoneNo;

}

package com.opm.opmservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DS")
public class Ds {
    @Id
    @Column(name = "DS_ID")
    private Long dsId;

    @Column(name = "DS_CODE")
    @Size(max = 100)
    private String dsCode;

    @Column(name = "DS_CONTENT",columnDefinition = "CLOB")
    private String dsContent;

    @Column(name = "DS_TYPE_ID")
    private Long dsTypeId;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "ASSIGN_USER_ID")
    private Long assignUserId;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    @Column(name = "CREATED_USER")
    private Long createdUser;

    @Column(name = "UPDATED_USER")
    private Long updatedUser;






}

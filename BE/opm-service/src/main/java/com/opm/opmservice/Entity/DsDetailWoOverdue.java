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
@Table(name = "DS_DETAIL_WO_OVERDUE")
public class DsDetailWoOverdue {
    @Id
    @Column(name = "DETAIL_WO_OVERDUE_ID")
    private Long detailWoOverdueId;

    @Column(name = "DS_ID")
    private Long dsId;

    @Column(name = "WO_CODE")
    @Size(max = 100)
    private String woCode;

    @Column(name = "WO_CONTENT",columnDefinition = "CLOB")
    private String woContent;

    @Column(name = "WO_TYPE_ID")
    private Long woTypeId;

    @Column(name = "WO_STATUS")
    private Long woStatus;

    @Column(name = "WO_CREATED_TIME")
    private Date woCreatedTime;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "FINISH_TIME")
    private Date finishTime;

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

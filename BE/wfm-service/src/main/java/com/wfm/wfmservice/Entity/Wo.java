package com.wfm.wfmservice.Entity;

import com.example.common.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WO")
public class Wo extends BaseEntity {
    @Id
    @Column(name = "WO_ID")
    private Long woId;

    @Column(name = "WO_CODE")
    @Size(max = 100)
    private String woCode;

    @Column(name = "WO_CONTENT",columnDefinition = "CLOB")
    private String woContent;

    @Column(name = "WO_TYPE_ID")
    private Long woTypeId;

    @Column(name = "PRIORITY_ID")
    private Long priorityId;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "FINISH_TIME")
    private Date finishTime;

    @Column(name = "ASSIGN_USER_ID")
    private Long assignUserId;


}

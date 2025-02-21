package com.wfm.wfmservice.DTO.Wo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WoCUDto {
    private Long woId;
    private String woCode;
    private String woContent;
    private Long woTypeId;
    private Long priorityId;
    private Long status;
    private Date startTime;
    private Date endTime;
    private Date finishTime;
    private Long assignUserId;
}

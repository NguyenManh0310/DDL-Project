package com.wfm.wfmservice.DTO.Wo;


import com.example.common.BaseEntity.BaseEntityDto;
import com.wfm.wfmservice.Entity.Wo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WoDetailDto extends BaseEntityDto {
    private Long woId;
    private String woCode;
    private String woContent;
    //
    private String woTypeName;
    private String priorityName;
    //
    private Long status;
    private Date startTime;
    private Date endTime;
    private Date finishTime;
    //
    private String assignUserFullName;

    public WoDetailDto(Wo wo) {
        if (wo != null) {
            this.woId = wo.getWoId();
            this.woCode = wo.getWoCode();
            this.woContent = wo.getWoContent();
            this.status = wo.getStatus();
            this.startTime = wo.getStartTime();
            this.endTime = wo.getEndTime();
            this.finishTime = wo.getFinishTime();
            super.setCreatedUser(wo.getCreatedUser());
            super.setUpdatedUser(wo.getUpdatedUser());
            super.setCreatedTime(wo.getCreatedTime());
            super.setUpdatedTime(wo.getUpdatedTime());
        }
    }
}

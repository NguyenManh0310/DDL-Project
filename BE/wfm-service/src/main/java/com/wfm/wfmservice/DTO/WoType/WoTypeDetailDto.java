package com.wfm.wfmservice.DTO.WoType;

import com.example.common.BaseEntity.BaseEntityDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wfm.wfmservice.Entity.WoType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class WoTypeDetailDto extends BaseEntityDto {
    private Long woTypeId;
    private String woTypeCode;
    private String woTypeName;

    private Double processTime;
    private Long status;

    public WoTypeDetailDto(WoType woType) {
        if (woType != null) {
            this.woTypeId = woType.getWoTypeId();
            this.woTypeCode = woType.getWoTypeCode();
            this.woTypeName = woType.getWoTypeName();
            this.processTime = woType.getProcessTime();
            this.status=woType.getStatus();
            super.setCreatedUser(woType.getCreatedUser());
            super.setUpdatedUser(woType.getUpdatedUser());
            super.setCreatedTime(woType.getCreatedTime());
            super.setUpdatedTime(woType.getUpdatedTime());
        }

    }
}

package com.wfm.wfmservice.DTO.WoConfigBusiness;

import com.example.common.BaseEntity.BaseEntityDto;
import com.wfm.wfmservice.Entity.WoConfigBusiness;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WoConfigBusinessDetailDto extends BaseEntityDto {
    private Long configBusinessId;
    private String woTypeName;
    private String priorityName;
    private String oldStatus;
    private String newStatus;

    public WoConfigBusinessDetailDto(WoConfigBusiness woConfigBusiness) {
        if (woConfigBusiness != null) {
            this.configBusinessId = woConfigBusiness.getConfigBusinessId();
            super.setCreatedUser(woConfigBusiness.getCreatedUser());
            super.setUpdatedUser(woConfigBusiness.getUpdatedUser());
            super.setCreatedTime(woConfigBusiness.getCreatedTime());
            super.setUpdatedTime(woConfigBusiness.getUpdatedTime());
        }
    }
}

package com.wfm.wfmservice.DTO.WoConfigBusiness;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WoConfigBusinessCUDto {
    private Long configBusinessId;
    private Long woTypeId;
    private Long priorityId;
    private Long oldStatus;
    private Long newStatus;

}

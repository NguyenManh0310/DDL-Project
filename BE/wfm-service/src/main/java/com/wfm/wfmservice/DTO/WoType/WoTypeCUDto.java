package com.wfm.wfmservice.DTO.WoType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WoTypeCUDto{
    private Long woTypeId;
    private String woTypeCode;
    private String woTypeName;
    private Long priorityId;
    private Double processTime;
    private Long status;
}

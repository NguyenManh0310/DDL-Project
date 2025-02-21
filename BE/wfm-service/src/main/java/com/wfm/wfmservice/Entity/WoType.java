package com.wfm.wfmservice.Entity;

import com.example.common.BaseEntity.BaseEntity;
import com.wfm.wfmservice.DTO.WoType.WoTypeCUDto;
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
@Table(name = "WO_TYPE")
public class WoType extends BaseEntity {
    @Id
    @Column(name = "WO_TYPE_ID")
    private Long woTypeId;

    @Column(name = "WO_TYPE_CODE")
    @Size(max = 100)
    private String woTypeCode;

    @Column(name = "WO_TYPE_NAME")
    @Size(max = 500)
    private String woTypeName;

    @Column(name = "PROCESS_TIME")
    private Double processTime;

    @Column(name = "STATUS")
    private Long status;
    public WoType(WoTypeCUDto woTypeCUDto) {
        if (woTypeCUDto != null) {
            this.woTypeName = woTypeCUDto.getWoTypeName();
            this.woTypeCode = woTypeCUDto.getWoTypeCode();
            this.processTime = woTypeCUDto.getProcessTime();
        }
    }
}

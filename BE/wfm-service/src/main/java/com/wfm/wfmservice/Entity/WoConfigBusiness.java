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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WO_CONFIG_BUSINESS")
public class WoConfigBusiness extends BaseEntity {
    @Id
    @Column(name = "CONFIG_BUSINESS_ID")
    private Long configBusinessId;

    @Column(name = "WO_TYPE_ID")
    private Long woTypeId;

    @Column(name = "PRIORITY_ID")
    private Long priorityId;

    @Column(name = "OLD_STATUS")
    private Long oldStatus;

    @Column(name = "NEW_STATUS")
    private Long newStatus;

}

package com.opm.opmservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DS_CONFIG_KPI_GROUP")
public class DsConfigKpiGroup {
    @Id
    @Column(name = "CONFIG_KPI_GROUP_ID")
    private Long configKpiGroupId;

    @Column(name = "WO_TYPE_ID")
    private Long woTypeId;

    @Column(name = "PRIORITY_ID")
    private Long priorityId;

    @Column(name = "KPI_GROUP_ID")
    private Long kpiGroupId;

    @Column(name = "price", precision = 10, scale = 2, nullable = false) // Khai báo NUMBER(10, 2)
    private BigDecimal price;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    @Column(name = "CREATED_USER")
    private Long createdUser;

    @Column(name = "UPDATED_USER")
    private Long updatedUser;
}

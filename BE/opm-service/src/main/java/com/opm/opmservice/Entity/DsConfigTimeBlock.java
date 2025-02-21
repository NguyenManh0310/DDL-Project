package com.opm.opmservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "DS_CONFIG_TIME_BLOCK")
public class DsConfigTimeBlock {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONFIG_KPI_GROUP_ID")
    private Long configKpiGroupId;

    @Column(name = "HOUR_START")
    private Long hourStart;

    @Column(name = "HOUR_END")
    private Long hourEnd;

    @Column(name = "HOUR_BLOCK")
    private Long hourBlock;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    @Column(name = "CREATED_USER")
    private Long createdUser;

    @Column(name = "UPDATED_USER")
    private Long updatedUser;
}

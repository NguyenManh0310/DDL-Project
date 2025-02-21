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
@Table(name = "DS_CONFIG_BUSINESS")
public class DsConfigBusiness {
    @Id
    @Column(name = "CONFIG_BUSINESS_ID")
    private Long dsConfigBusinessId;

    @Column(name = "DS_TYPE_ID")
    private Long dsTypeId;

    @Column(name = "OLD_STATUS")
    private String oldStatus;

    @Column(name = "NEW_STATUS")
    private String newStatus;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    @Column(name = "CREATED_USER")
    private Long createdUser;

    @Column(name = "UPDATED_USER")
    private Long updatedUser;
}

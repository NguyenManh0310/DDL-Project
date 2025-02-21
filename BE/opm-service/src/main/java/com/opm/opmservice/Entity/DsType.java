package com.opm.opmservice.Entity;

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
@Table(name = "DS_TYPE")
public class DsType {
    @Id
    @Column(name = "DS_TYPE_ID")
    private Long dsTypeId;

    @Column(name = "DS_TYPE_CODE")
    @Size(max = 100)
    private String dsTypeCode;

    @Column(name = "DS_TYPE_NAME")
    @Size(max = 500)
    private String dsTypeName;

    @Column(name = "PROCESS_TIME")
    private Long processTime;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    @Column(name = "CREATED_USER")
    private Long createdUser;

    @Column(name = "UPDATED_USER")
    private Long updatedUser;
}

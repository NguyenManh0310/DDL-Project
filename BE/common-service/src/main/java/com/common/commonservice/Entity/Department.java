package com.common.commonservice.Entity;

import com.common.commonservice.DTO.Department.DepartmentCUDto;
import com.example.common.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq_gen")
    @SequenceGenerator(name = "department_seq_gen", sequenceName = "COMMON.DEPARTMENT_SEQ", allocationSize = 1)
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "DEPARTMENT_CODE")
    @Size(max = 100)
    private String departmentCode;

    @Column(name = "DEPARTMENT_NAME")
    @Size(max = 500)
    private String departmentName;

    @Column(name = "PARENT_DEPARTMENT_ID")
    private Long parentDepartmentId;

    @Column(name = "STATUS")
    private Long status;

    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private List<User> users;

    public Department(DepartmentCUDto departmentCUDto){
        if(departmentCUDto !=null){
            this.departmentName= departmentCUDto.getDepartmentName().trim().replaceAll("\\s+", " ");
            this.departmentCode= departmentCUDto.getDepartmentCode().trim().replaceAll("\\s+", " ");
        }
    }
}

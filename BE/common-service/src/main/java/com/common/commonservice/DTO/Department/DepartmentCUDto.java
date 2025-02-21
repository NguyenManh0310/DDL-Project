package com.common.commonservice.DTO.Department;

import com.common.commonservice.Entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.common.BaseEntity.BaseEntityDto;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentCUDto extends BaseEntityDto {
    private Long departmentId;
    private String departmentCode;
    private String departmentName;
    private Long parentDepartmentId;
    private Long status;

    public DepartmentCUDto(Department department) {
        if (department != null) {
            this.departmentId = department.getDepartmentId();
            this.departmentCode = department.getDepartmentCode();
            this.departmentName = department.getDepartmentName();
            this.parentDepartmentId = department.getParentDepartmentId();
            this.status = department.getStatus();
        }

    }
}

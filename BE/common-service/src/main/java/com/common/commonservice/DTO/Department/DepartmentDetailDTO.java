package com.common.commonservice.DTO.Department;

import com.common.commonservice.Convert.CommonConvertEntity;
import com.common.commonservice.Entity.Department;
import com.example.common.BaseEntity.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDetailDTO extends BaseEntityDto {
    private Long departmentId;
    private String departmentCode;
    private String departmentName;
    private String parentDepartmentName;
    private Long status;

    public DepartmentDetailDTO(Department department){
        if(department!=null){
            this.departmentId=department.getDepartmentId();
            this.departmentCode=department.getDepartmentCode();
            this.departmentName=department.getDepartmentName();
            this.status=department.getStatus();
            super.setCreatedUser(department.getCreatedUser());
            super.setUpdatedUser(department.getUpdatedUser());
            super.setCreatedTime(department.getCreatedTime());
            super.setUpdatedTime(department.getUpdatedTime());
        }
    }

}
